package iron.bsw.buysell.repositories;

import iron.bsw.buysell.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.jws.soap.SOAPBinding;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail (String email);
}
