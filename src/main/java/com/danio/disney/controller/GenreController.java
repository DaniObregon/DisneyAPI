package com.danio.disney.controller;

import com.danio.disney.dto.GenreDTO;
import com.danio.disney.model.Genre;
import com.danio.disney.service.GenreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/genres")
public class GenreController {
    public final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping
    public ResponseEntity<GenreDTO> addGenre(Genre genre, MultipartFile file) {
        if (Objects.nonNull(file)) genreService.saveGenre(genre, file);
        return new ResponseEntity<>(GenreDTO.from(genre), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GenreDTO>> getGenres(){
        List<Genre> genres = genreService.findAllGenres();
        List<GenreDTO> genreDTOS = new ArrayList<>();
        genreDTOS = genres.stream().map(GenreDTO :: from).collect(Collectors.toList());
        return new ResponseEntity<>(genreDTOS, HttpStatus.OK);
    }
}