package com.danio.disney.service;

import com.danio.disney.exception.CharacterNotFoundException;
import com.danio.disney.model.Character;
import com.danio.disney.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final CharacterImageService characterImageService;

    @Autowired
    public CharacterService(CharacterRepository characterRepository, CharacterImageService characterImageService) {
        this.characterRepository = characterRepository;
        this.characterImageService = characterImageService;
    }

    public Character findCharacterById(Long id) {
        Character character = characterRepository.findById(id).orElseThrow(() -> new CharacterNotFoundException(id));
        return character;
    }

    public Character saveCharacter(Character character, MultipartFile file) {
        character.setCharacterImage(characterImageService.saveCharacterImage(file));
        return characterRepository.save(character);
    }

    public List<Character> findAllCharacters(){
        List<Character> characters = characterRepository.findAll();
        return characters;
    }

    public Character deleteCharacterById(Long id){
        Character character = this.findCharacterById(id);
        characterImageService.deleteCharacterImageById(character.getCharacterImage().getId());
        characterRepository.deleteById(character.getId());
        return character;
    }
}
