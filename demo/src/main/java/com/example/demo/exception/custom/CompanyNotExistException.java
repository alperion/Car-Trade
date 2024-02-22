package com.example.demo.exception.custom;

public class CompanyNotExistException extends RuntimeException{
    public CompanyNotExistException() {
        super();
    }

    public CompanyNotExistException(String message) {
        super(message);
    }
}
