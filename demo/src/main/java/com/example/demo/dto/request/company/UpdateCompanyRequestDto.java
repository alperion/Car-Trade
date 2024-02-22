package com.example.demo.dto.request.company;

public class UpdateCompanyRequestDto {

    private String companyName;
    private String companyId;
    private String token;

    public UpdateCompanyRequestDto(String companyName, String companyId, String token) {
        this.companyName = companyName;
        this.companyId = companyId;
        this.token = token;
    }

    public UpdateCompanyRequestDto() {
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

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
