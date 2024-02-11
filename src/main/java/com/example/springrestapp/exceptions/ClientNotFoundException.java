package com.example.springrestapp.exceptions;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(String message){
        super(message);
    }
}
