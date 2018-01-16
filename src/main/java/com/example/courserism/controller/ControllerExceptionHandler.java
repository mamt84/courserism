package com.example.courserism.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler
{
    @ExceptionHandler(
    { IllegalArgumentException.class } )
    public ResponseEntity<Object> badRequest()
    {
        return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
    }
}
