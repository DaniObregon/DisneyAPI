package com.danio.disney.controller;

import com.danio.disney.dto.SeriesDTO;
import com.danio.disney.model.Series;
import com.danio.disney.service.SeriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/series")
public class SeriesController {
    private final SeriesService seriesService;

    public SeriesController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @PostMapping
    public ResponseEntity<SeriesDTO> addSeries(Series series, MultipartFile file){
        if(Objects.nonNull(file)) seriesService.saveSeries(series, file);
        return new ResponseEntity<>(SeriesDTO.from(series), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SeriesDTO>> getSeries(){
        List<Series> series = seriesService.findAllSeries();
        List<SeriesDTO> seriesDTOS = new ArrayList<>();
        seriesDTOS = series.stream().map(SeriesDTO::from).collect(Collectors.toList());
        return new ResponseEntity<>(seriesDTOS, HttpStatus.OK);
    }
}
