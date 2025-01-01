package com.naum.spring_boot_project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException{
    private static long serialVersionUID = 1L;

    public UnsupportedMathOperationException(String exception) {
        super(exception);
    }
}
