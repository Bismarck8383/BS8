package com.bosonit.BS8.BS8.infraestructura.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class ControladorExceptions extends ResponseEntityExceptionHandler {
    public ResponseEntity<CustomError> ControladorNotFoundException (NotFoundException nfe) {
        CustomError ce = new CustomError(new Date(), 404, nfe.getMessage());
        return new ResponseEntity<CustomError>(ce, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnprocesableException.class)
    public ResponseEntity<CustomError> ControladorUnprocessableException (UnprocesableException ue) {
        CustomError ce = new CustomError(new Date(), 422, ue.getMessage());
        return new ResponseEntity<CustomError>(ce, HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
