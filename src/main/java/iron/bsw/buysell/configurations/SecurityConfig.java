package iron.bsw.buysell.configurations;

import iron.bsw.buysell.services.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity //включаем spring security в конфигурацию
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomUserDetailsService userDetailsService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/product/**", "/images/**", "/registration") //перечисляем какие url будут доступны
                .permitAll() //разрешаем
                .anyRequest().authenticated()  //требуем аунтификацию юзера
                .and()                         //ключевое слово
                .formLogin()                   //конфигурируем форму логина
                .loginPage("/login")           //адрес формы логина
                .permitAll()                   //даём разрешение
                .and()
                .logout()                      //конфигурируем logout
                .permitAll();                  //разрешаем logout

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());

    }

    @Bean //создали бин в контексте
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }
}
