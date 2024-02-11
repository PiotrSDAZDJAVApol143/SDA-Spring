package com.example.springrestapp.controller.exceptionHandler;

import com.example.springrestapp.exceptions.OwnCarExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerExceptionHandler {
    @ExceptionHandler(OwnCarExceptions.class)
    public ResponseEntity<String> handlerExistingCarException(OwnCarExceptions ownCarExceptions){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ownCarExceptions.getMessage());
    }
}
