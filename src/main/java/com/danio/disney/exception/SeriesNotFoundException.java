package com.danio.disney.exception;

import java.text.MessageFormat;

public class SeriesNotFoundException extends RuntimeException{
    public SeriesNotFoundException(Long id) {
        super(MessageFormat.format("La serie con el id {0} no fue encontrado!", id));
    }
}
