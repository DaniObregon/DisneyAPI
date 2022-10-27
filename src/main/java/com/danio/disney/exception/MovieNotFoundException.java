package com.danio.disney.exception;

import java.text.MessageFormat;

public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException(Long id) {
        super(MessageFormat.format("El pelicula con el id {0} no fue encontrado!", id));
    }
}
