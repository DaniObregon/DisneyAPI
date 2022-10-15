package com.danio.disney.service;

import com.danio.disney.model.Series;
import com.danio.disney.repository.SeriesRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class SeriesService {
    public final SeriesRepository seriesRepository;
    public final SeriesImageService seriesImageService;

    public SeriesService(SeriesRepository seriesRepository, SeriesImageService seriesImageService) {
        this.seriesRepository = seriesRepository;
        this.seriesImageService = seriesImageService;
    }

    public Series saveSeries(Series series, MultipartFile file) {
        series.setSeriesImage(seriesImageService.saveSeriesImage(file));
        return seriesRepository.save(series);
    }

    public List<Series> findAllSeries(){
        return seriesRepository.findAll();
    }
}
