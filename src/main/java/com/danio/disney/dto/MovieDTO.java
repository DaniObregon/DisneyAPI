package com.danio.disney.dto;

import com.danio.disney.model.Movie;
import lombok.Data;

import java.util.Date;

@Data
public class MovieDTO {

    private Long id;
    private String title;
    private Date date;
    private int rating;
    private Long imageId;

    public static MovieDTO from(Movie movie){
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setTitle(movie.getTitle());
        movieDTO.setDate(movie.getDate());
        movieDTO.setRating(movie.getRating());
        movieDTO.setImageId(movie.getMovieImage().getId());
        return movieDTO;
    }
}
