package com.example.demo.exception.custom;

public class InvalidRoleException extends RuntimeException{


    public InvalidRoleException() {
    }

    public InvalidRoleException(String message) {
        super(message);
    }
}
