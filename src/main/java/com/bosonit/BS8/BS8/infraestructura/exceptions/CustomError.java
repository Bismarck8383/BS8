package com.bosonit.BS8.BS8.infraestructura.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomError {
    private Date timestamp;
    private int HttpCode;
    private String mensajeError;
}
