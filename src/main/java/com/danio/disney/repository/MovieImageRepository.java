package com.danio.disney.repository;

import com.danio.disney.imageresources.MovieImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieImageRepository extends JpaRepository<MovieImage, Long> {
}
