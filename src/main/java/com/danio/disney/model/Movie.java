package com.danio.disney.model;

import com.danio.disney.imageresources.MovieImage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Long id;

    private String title;

    @ApiModelProperty(value = "yyyy/MM/dd", example = "2022/02/22")
    private Date date;

    private int rating;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_image_fk")
    private MovieImage movieImage;

    private GenreChoose genreChoose;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "movie_genre_fk")
//    private Genre genre;

    @ManyToMany(mappedBy = "linkedMovies")
    private List<Character> linkedCharacters = new ArrayList<>();

    public void addCharacter(Character character){
        this.linkedCharacters.add(character);
    }

    public void removeCharacter(Character character){
        this.linkedCharacters.remove(character);
    }
}
