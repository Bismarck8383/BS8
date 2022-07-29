package com.bosonit.BS8.BS8.infraestructura.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException  extends RuntimeException{
    public NotFoundException(String mensajeError){
        super(mensajeError);
    }
}
