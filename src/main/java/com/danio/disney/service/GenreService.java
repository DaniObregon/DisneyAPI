package com.danio.disney.service;

import com.danio.disney.model.Genre;
import com.danio.disney.repository.GenreRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class GenreService {
    private final GenreRepository genreRepository;
    private final GenreImageService genreImageService;


    public GenreService(GenreRepository genreRepository, GenreImageService genreImageService) {
        this.genreRepository = genreRepository;
        this.genreImageService = genreImageService;
    }

    public Genre saveGenre(Genre genre, MultipartFile file){
        genre.setGenreImage(genreImageService.saveGenreImage(file));
        return genreRepository.save(genre);
    }

    public List<Genre> findAllGenres(){
        return genreRepository.findAll();
    }
}
