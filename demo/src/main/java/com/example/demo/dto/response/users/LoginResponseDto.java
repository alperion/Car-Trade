package com.example.demo.dto.response.users;


public class LoginResponseDto {

    private String token;
    private String message;
    private int statusCode;

    public LoginResponseDto(String token, String message, int statusCode) {
        this.token = token;
        this.message = message;
        this.statusCode = statusCode;
    }

    public LoginResponseDto() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
