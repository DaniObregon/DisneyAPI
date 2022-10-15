package com.danio.disney.model;

import com.danio.disney.imageresources.SeriesImage;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
//@Table(name = "SeriesTable")
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Date date;

    private int rating;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "series_image_fk")
    private SeriesImage seriesImage;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_genre_fk")
    private Genre genre;

//    @ManyToMany
//    @ManyToMany(mappedBy = "linkedSeriesLS")
//    private List<Character> linkedCharacters = new ArrayList<>();
//
//    public void addCharacter(Character character){
//        this.linkedCharacters.add(character);
//    }
//
//    public void removeCharacter(Character character){
//        this.linkedCharacters.remove(character);
//    }
}
