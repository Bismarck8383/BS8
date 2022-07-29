package com.bosonit.BS8.BS8.infraestructura.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocesableException  extends  RuntimeException{
    public UnprocesableException(String mensajeError) {
        super (mensajeError);
    }
}