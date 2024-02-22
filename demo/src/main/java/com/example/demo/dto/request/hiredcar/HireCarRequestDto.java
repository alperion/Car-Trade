package com.example.demo.dto.request.hiredcar;

public class HireCarRequestDto {

    private String token ;
    private String carId;
    private int day;
    public HireCarRequestDto(String token, String carId, int day) {
        this.token = token;
        this.carId = carId;
        this.day = day;
    }

    public HireCarRequestDto() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
