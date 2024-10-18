package com.personal.ems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class NullVariableException extends RuntimeException {
    public NullVariableException(String message){
        super(message);
    }
}
