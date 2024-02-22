package com.example.demo.dto.response;

public class BaseResponseDto {

    private String message ;
    private int statusCode;

    public BaseResponseDto(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public BaseResponseDto() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
