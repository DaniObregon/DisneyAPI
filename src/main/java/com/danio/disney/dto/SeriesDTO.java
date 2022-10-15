package com.danio.disney.dto;

import com.danio.disney.model.Series;
import lombok.Data;

import java.util.Date;

@Data
public class SeriesDTO {
    private Long id;
    private String title;
    private Date date;
    private int rating;
    private Long imageId;

    public static SeriesDTO from(Series series){
        SeriesDTO seriesDTO = new SeriesDTO();
        seriesDTO.setId(series.getId());
        seriesDTO.setTitle(series.getTitle());
        seriesDTO.setDate(series.getDate());
        seriesDTO.setRating(series.getRating());
        seriesDTO.setImageId(series.getSeriesImage().getId());
        return seriesDTO;
    }
}