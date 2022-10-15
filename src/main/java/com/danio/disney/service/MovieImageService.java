package com.danio.disney.service;

import com.danio.disney.imageresources.MovieImage;
import com.danio.disney.repository.MovieImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class MovieImageService {
    private final MovieImageRepository movieImageRepository;

    @Autowired
    public MovieImageService(MovieImageRepository movieImageRepository) {
        this.movieImageRepository = movieImageRepository;
    }

    public MovieImage saveMovieImage(MultipartFile file){
        MovieImage movieImage = new MovieImage();
        try {
            movieImage.setData(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        movieImage.setName(file.getOriginalFilename());
        movieImage.setType(file.getContentType());
        movieImageRepository.save(movieImage);
        return movieImage;
    }
}
