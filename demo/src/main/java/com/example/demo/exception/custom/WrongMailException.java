package com.example.demo.exception.custom;

public class WrongMailException extends RuntimeException{


    public WrongMailException() {
        super();
    }

    public WrongMailException(String message) {
        super(message);
    }
}
