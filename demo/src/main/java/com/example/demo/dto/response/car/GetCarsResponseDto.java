package com.example.demo.dto.response.car;

import java.util.List;

public class GetCarsResponseDto {

   private  List<GetCarField> getCarFields;

    public GetCarsResponseDto(List<GetCarField> getCarFields) {
        this.getCarFields = getCarFields;
    }

    public GetCarsResponseDto() {
    }

    public List<GetCarField> getGetCarFields() {
        return getCarFields;
    }

    public void setGetCarFields(List<GetCarField> getCarFields) {
        this.getCarFields = getCarFields;
    }
}
