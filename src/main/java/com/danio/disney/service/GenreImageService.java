package com.danio.disney.service;

import com.danio.disney.imageresources.GenreImage;
import com.danio.disney.repository.GenreImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class GenreImageService {
    private final GenreImageRepository genreImageRepository;

    public GenreImageService(GenreImageRepository genreImageRepository) {
        this.genreImageRepository = genreImageRepository;
    }

    public GenreImage saveGenreImage(MultipartFile file){
        GenreImage genreImage = new GenreImage();
        try {
            genreImage.setData(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        genreImage.setName(file.getOriginalFilename());
        genreImage.setType(file.getContentType());
        return genreImage;
    }
}
