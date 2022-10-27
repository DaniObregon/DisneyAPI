package com.danio.disney.service;

import com.danio.disney.exception.CharacterNotFoundException;
import com.danio.disney.imageresources.CharacterImage;
import com.danio.disney.repository.CharacterImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class CharacterImageService {
    private final CharacterImageRepository characterImageRepository;

    public CharacterImageService(CharacterImageRepository characterImageRepository) {
        this.characterImageRepository = characterImageRepository;
    }

    public CharacterImage findCharacterImageById(Long id){
        CharacterImage characterImage = characterImageRepository.findById(id).orElseThrow(() -> new CharacterNotFoundException(id));
        return characterImage;
    }

    public CharacterImage saveCharacterImage(MultipartFile file){
        CharacterImage characterImage = new CharacterImage();
        try {
            characterImage.setData(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        characterImage.setName(file.getOriginalFilename());
        characterImage.setType(file.getContentType());
        characterImageRepository.save(characterImage);
        return characterImage;
    }

    public void deleteCharacterImageById(Long id){
        characterImageRepository.deleteById(id);
    }
}