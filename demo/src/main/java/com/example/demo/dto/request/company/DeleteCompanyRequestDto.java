package com.example.demo.dto.request.company;


public class DeleteCompanyRequestDto {

    private String token;
    private String companyId;

    public DeleteCompanyRequestDto(String token, String companyId) {
        this.token = token;
        this.companyId = companyId;
    }

    public DeleteCompanyRequestDto() {
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

