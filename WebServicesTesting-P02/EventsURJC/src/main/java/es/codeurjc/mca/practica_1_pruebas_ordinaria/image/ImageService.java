package es.codeurjc.mca.practica_1_pruebas_ordinaria.image;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    public String createImage(MultipartFile multiPartFile);

    public void deleteImage(String image);
}
