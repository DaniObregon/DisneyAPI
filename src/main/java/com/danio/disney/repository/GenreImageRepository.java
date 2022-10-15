package com.danio.disney.repository;

import com.danio.disney.imageresources.GenreImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreImageRepository extends JpaRepository<GenreImage, Long> {
}
