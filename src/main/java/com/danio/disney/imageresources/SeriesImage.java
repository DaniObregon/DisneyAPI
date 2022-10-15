package com.danio.disney.imageresources;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
//@Table(name = "SeriesImageTable")
public class SeriesImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;

    @Lob
    private byte[] data;
}
