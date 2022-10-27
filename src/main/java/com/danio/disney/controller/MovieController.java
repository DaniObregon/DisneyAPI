package com.danio.disney.controller;

import com.danio.disney.dto.MovieDTO;
import com.danio.disney.model.GenreChoose;
import com.danio.disney.model.Movie;
import com.danio.disney.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<MovieDTO> addMovie(@PathVariable MultipartFile file, Movie movie){
        if(Objects.nonNull(file)) movieService.saveMovie(movie, file);
        return new ResponseEntity<>(MovieDTO.from(movie), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getMovies(){
        List<Movie> movies = movieService.findAllMovies();
        List<MovieDTO> movieDTOS = new ArrayList<>();
        movieDTOS = movies.stream().map(MovieDTO :: from).collect(Collectors.toList());
        return new ResponseEntity<>(movieDTOS, HttpStatus.OK);
    }
}
