package com.tyfah.pockerhandevaluator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_IMPLEMENTED)
public class NotImplementedException extends RuntimeException{
    public NotImplementedException(String message) {
        super(message);
    }
}
