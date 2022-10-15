package com.danio.disney.dto;

import com.danio.disney.model.Genre;
import lombok.Data;

@Data
public class GenreDTO {
    private Long id;
    private String name;
    private Long imageId;

    public static GenreDTO from(Genre genre){
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setId(genre.getId());
        genreDTO.setName(genre.getName());
        genreDTO.setImageId(genre.getGenreImage().getId());
        return genreDTO;
    }
}
