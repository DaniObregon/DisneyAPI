package com.danio.disney.controller;

import com.danio.disney.dto.CharacterDTO;
import com.danio.disney.model.Character;
import com.danio.disney.service.CharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/characters")
public class CharacterController {
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping
    public ResponseEntity<CharacterDTO> addCharacter(@PathVariable MultipartFile file, Character character) {
        if (Objects.nonNull(file)) characterService.saveCharacter(character, file);
        return new ResponseEntity<>(CharacterDTO.from(character), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CharacterDTO>> getCharacters(){
        List<Character> characters = characterService.findAllCharacters();
        List<CharacterDTO> characterDTOS = characters.stream()
                .map(CharacterDTO :: from)
                .collect(Collectors.toList());
        return new ResponseEntity<>(characterDTOS, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<CharacterDTO> deleteCharacter(@PathVariable final Long id){
        Character character = characterService.deleteCharacterById(id);
        return new ResponseEntity<>(CharacterDTO.from(character), HttpStatus.OK);
    }

//    @DeleteMapping(value = "{id}")
//    public ResponseEntity<Void> deleteCharacter(@PathVariable Long id){
//        this.characterService.deleteCharacterById(id);
//        return ResponseEntity.noContent().build();
//    }


}