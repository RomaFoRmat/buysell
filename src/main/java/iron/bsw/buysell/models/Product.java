package iron.bsw.buysell.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="description", columnDefinition = "text")
    private String description;
    @Column(name="price")
    private int price;
    @Column(name="city")
    private String city;
//    @Column(name="author")
//    private String author;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private List<Image> images = new ArrayList<>();
    private Long previewImageId;
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY) //refresh-при удаление товара никак не должно отразится на сущности user
    @JoinColumn()
    private User user;
    private LocalDateTime dateOfCreated;

    @PrePersist //инициализация бина в спринге
    private void init() {
        dateOfCreated = LocalDateTime.now();
    }

    //добавление фотографии
    public void addImageToProduct(Image image) {
        image.setProduct(this);//устанавливаем товар текущий
        images.add(image);
    }
}
