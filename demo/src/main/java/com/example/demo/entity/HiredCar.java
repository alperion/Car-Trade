package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class HiredCar {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private String id;
        private String carId;
        private String userId;
        private Date hiredDate;
        private Date endDate;

    public HiredCar(String id, String carId, String userId, Date hiredDate, Date endDate) {
        this.id = id;
        this.carId = carId;
        this.userId = userId;
        this.hiredDate = hiredDate;
        this.endDate = endDate;
    }

    public HiredCar() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
