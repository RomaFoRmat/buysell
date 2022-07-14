package iron.bsw.buysell.controllers;

import iron.bsw.buysell.models.Image;
import iron.bsw.buysell.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController //не возвращает представление
@RequiredArgsConstructor
public class ImageController {
    private final ImageRepository imageRepository;

    //получать фото из БД,преобразовывать её байты в саму фотографию и её раздавать
    @GetMapping("/images/{id}")
    private ResponseEntity<?> getImageById(@PathVariable Long id) {
        Image image = imageRepository.findById(id).orElse(null);
        return ResponseEntity.ok()
                .header("fileName",image.getOriginalFileName()) // заголовок
                .contentType(MediaType.valueOf(image.getContentType()))   // преобразование contentType(тип фотографии) в константу ENUM ЬувшфЕнзу
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));

    }
}
