package com.example.demo.dto.request.company;

public class AddCompanyRequestDto {

    private String companyName;
    private String token;

    public AddCompanyRequestDto(String companyName,  String token) {
        this.companyName = companyName;

        this.token = token;
    }

    public AddCompanyRequestDto() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
