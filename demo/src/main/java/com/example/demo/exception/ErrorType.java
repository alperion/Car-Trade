package com.example.demo.exception;

public enum ErrorType {

    EMAIL_ALREADY_EXISTS(15001,"Email already exists"),
    TOKEN_NOT_VALID(16002,"Wrong token"),
    INVALID_ROLE(17001,"Invalid Role"),
    COMPANY_NOT_EXIST(13001,"Company not exist"),
    MONEY_NOT_ENOUGH(15002,"Money not enough"),
    WRONG_MAIL(15003,"Wrong Mail"),
    WRONG_PASSWORD(15004,"Wrong password");

    ;


    ErrorType(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    int statusCode;
    String message;


}
