package com.personal.ems.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class UnAcceptableVariableException extends RuntimeException {
    public UnAcceptableVariableException(String message){
        super(message);
    }
}
