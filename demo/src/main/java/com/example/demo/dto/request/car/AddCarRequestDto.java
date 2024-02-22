package com.example.demo.dto.request.car;

public class AddCarRequestDto {


    private String name;
    private String companyId;
    private int cost;
    private String token;

    public AddCarRequestDto(String name, String companyId, int cost, String token) {
        this.name = name;
        this.companyId = companyId;
        this.cost = cost;
        this.token = token;
    }

    public AddCarRequestDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
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
}
