package com.example.demo.exception.custom;

public class MoneyNotEnoughException extends RuntimeException{

    public MoneyNotEnoughException() {
        super();
    }

    public MoneyNotEnoughException(String message) {
        super(message);
    }
}
