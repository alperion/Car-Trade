package com.example.demo.exception.custom;

public class TokenNotValidException extends RuntimeException{

    public TokenNotValidException() {
        super();
    }

    public TokenNotValidException(String message) {
        super(message);
    }
}
