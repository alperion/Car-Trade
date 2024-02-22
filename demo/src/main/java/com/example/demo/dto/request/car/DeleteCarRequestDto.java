package com.example.demo.dto.request.car;

public class DeleteCarRequestDto {

    private String carId;
    private String token ;

    public DeleteCarRequestDto(String carId, String token) {
        this.carId = carId;
        this.token = token;
    }

    public DeleteCarRequestDto() {
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
