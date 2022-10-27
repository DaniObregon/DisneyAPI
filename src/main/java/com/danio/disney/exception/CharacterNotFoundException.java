package com.danio.disney.exception;

import java.text.MessageFormat;

public class CharacterNotFoundException extends RuntimeException{
    public CharacterNotFoundException(Long id) {
        super(MessageFormat.format("El Personaje con el id {0} no fue encontrado!", id));
    }
}
