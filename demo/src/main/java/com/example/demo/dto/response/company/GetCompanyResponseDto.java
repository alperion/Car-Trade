package com.example.demo.dto.response.company;

import java.util.List;

public class GetCompanyResponseDto {

    List<GetCompanyField> companyFields;

    public GetCompanyResponseDto(List<GetCompanyField> companyFields) {
        this.companyFields = companyFields;
    }

    public GetCompanyResponseDto() {
    }

    public List<GetCompanyField> getCompanyFields() {
        return companyFields;
    }

    public void setCompanyFields(List<GetCompanyField> companyFields) {
        this.companyFields = companyFields;
    }
}
