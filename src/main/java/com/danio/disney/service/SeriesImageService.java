package com.danio.disney.service;

import com.danio.disney.imageresources.SeriesImage;
import com.danio.disney.repository.SeriesImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class SeriesImageService {
    private final SeriesImageRepository seriesImageRepository;

    public SeriesImageService(SeriesImageRepository seriesImageRepository) {
        this.seriesImageRepository = seriesImageRepository;
    }

    public SeriesImage saveSeriesImage(MultipartFile file){
        SeriesImage seriesImage = new SeriesImage();
        try {
            seriesImage.setData(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        seriesImage.setName(file.getOriginalFilename());
        seriesImage.setType(file.getContentType());
        seriesImageRepository.save(seriesImage);
        return seriesImage;
    }
}
