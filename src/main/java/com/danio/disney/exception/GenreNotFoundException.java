package com.danio.disney.exception;

import java.text.MessageFormat;

public class GenreNotFoundException extends RuntimeException{
    public GenreNotFoundException(Long id) {
        super(MessageFormat.format("El genero con el id {0} no fue encontrado!", id));
    }
}
