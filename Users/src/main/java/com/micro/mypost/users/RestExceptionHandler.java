package com.micro.mypost.users;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;


@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity<Map<String, String>> handler(MissingServletRequestParameterException exception) {
        return ResponseEntity.badRequest().body(Map.of("message", exception.getMessage()));
    }
}
