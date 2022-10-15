package com.danio.disney.service;

import com.danio.disney.model.Movie;
import com.danio.disney.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieImageService movieImageService;

    @Autowired
    public MovieService(MovieRepository movieRepository, MovieImageService movieImageService) {
        this.movieRepository = movieRepository;
        this.movieImageService = movieImageService;
    }

    public Movie saveMovie(Movie movie, MultipartFile file){
        movie.setMovieImage(movieImageService.saveMovieImage(file));
        return movieRepository.save(movie);
    }

    public List<Movie> findAllMovies(){
        return movieRepository.findAll();
    }
}
