package com.danio.disney.model;

import com.danio.disney.imageresources.CharacterImage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Long id;

    private String name;

    private String age;

    private String weight;

    private String story;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "character_image_fk")
    private CharacterImage characterImage;

    //-----------NUEVO

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.ALL})
    @JoinTable(name = "character_movie",
    joinColumns = @JoinColumn(name = "character_id"),
    inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie> linkedMovies = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.ALL})
    @JoinTable(name = "character_series",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "series_id"))
    private List<Series> linkedSeries = new ArrayList<>();
}