package com.example.demo.dto.request.car;

public class UpdateCarRequestDto {
    private String token;
    private String carId;
    private String name ;
    private int cost;

    public UpdateCarRequestDto(String token, String carId, String name, int cost) {
        this.token = token;
        this.carId = carId;
        this.name = name;
        this.cost = cost;
    }

    public UpdateCarRequestDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
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
}
