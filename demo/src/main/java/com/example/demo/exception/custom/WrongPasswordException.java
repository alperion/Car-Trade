package com.example.demo.exception.custom;

public class WrongPasswordException extends RuntimeException{


    public WrongPasswordException() {
        super();
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
