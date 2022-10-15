package com.danio.disney.repository;

import com.danio.disney.imageresources.CharacterImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterImageRepository extends JpaRepository<CharacterImage, Long> {
}
