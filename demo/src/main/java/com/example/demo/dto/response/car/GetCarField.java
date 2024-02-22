package com.example.demo.dto.response.car;

public class GetCarField {

    private String carId;
    private String carName;
    private int carCost;

    public GetCarField(String carId, String carName, int carCost) {
        this.carId = carId;
        this.carName = carName;
        this.carCost = carCost;
    }

    public GetCarField() {
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getCarCost() {
        return carCost;
    }

    public void setCarCost(int carCost) {
        this.carCost = carCost;
    }
}
