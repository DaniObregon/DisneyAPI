package com.danio.disney.repository;

import com.danio.disney.imageresources.SeriesImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesImageRepository extends JpaRepository<SeriesImage, Long> {
}
