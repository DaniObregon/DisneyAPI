package com.danio.disney.dbinit;

import com.danio.disney.model.Genre;
import com.danio.disney.repository.GenreRepository;
import com.danio.disney.service.GenreService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Component
public class DataLoader implements ApplicationRunner {

    private MultipartFile file;
    private final String genreImageFolder = "src/main/resources/static/img";
    private final GenreRepository genreRepository;
    private final GenreService genreService;

    public DataLoader(GenreRepository genreRepository, GenreService genreService) {
        this.genreRepository = genreRepository;
        this.genreService = genreService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createGenre("/musical.png", "Musical");
        createGenre("/adventure.png", "Adventure");
        createGenre("/comedy.png", "Comedy");
    }

    private void createGenre(String image, String nombre) {
        Genre genre = new Genre();
        File file = new File(genreImageFolder + image);
        try {
            FileInputStream input = new FileInputStream(file);
            this.file = new MockMultipartFile("FILENUEVO", file.getName(), MediaType.IMAGE_JPEG_VALUE, input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        genre.setName(nombre);
        genreService.saveGenre(genre, this.file);
    }
}
