package com.danio.disney.model;

import com.danio.disney.imageresources.GenreImage;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_image_fk")
    private GenreImage genreImage;

//    @OneToMany(cascade = CascadeType.ALL)//, mappedBy = "genre"
//    private List<Movie> relatedMovies = new ArrayList<>();
//
//    @OneToMany(cascade = CascadeType.ALL)//, mappedBy = "genre"
//    private List<Series> relatedSeries = new ArrayList<>();
}
