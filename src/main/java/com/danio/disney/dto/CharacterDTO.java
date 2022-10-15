package com.danio.disney.dto;

import com.danio.disney.model.Character;
import lombok.Data;

@Data
public class CharacterDTO {
    private Long id;
    private String name;
    private String age;
    private String weight;
    private String story;
    private Long imageId;

    public static CharacterDTO from(Character character) {
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setId(character.getId());
        characterDTO.setName(character.getName());
        characterDTO.setAge(character.getAge());
        characterDTO.setWeight(character.getWeight());
        characterDTO.setStory(character.getStory());
        characterDTO.setImageId(character.getCharacterImage().getId());
        return characterDTO;
    }
}
