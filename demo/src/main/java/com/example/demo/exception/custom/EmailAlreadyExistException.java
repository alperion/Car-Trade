package com.example.demo.exception.custom;

public class EmailAlreadyExistException extends RuntimeException{

    public EmailAlreadyExistException(String message) {
        super(message);
    }

    public EmailAlreadyExistException() {
        super();
    }
}
