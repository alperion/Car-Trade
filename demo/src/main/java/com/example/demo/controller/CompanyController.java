package com.example.demo.controller;

import com.example.demo.dto.request.company.UpdateCompanyRequestDto;
import com.example.demo.dto.request.company.AddCompanyRequestDto;
import com.example.demo.dto.request.company.DeleteCompanyRequestDto;
import com.example.demo.dto.response.BaseResponseDto;
import com.example.demo.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/addCompany")
    public ResponseEntity<BaseResponseDto> addCompany(@RequestBody AddCompanyRequestDto dto){
            return ResponseEntity.ok(companyService.addCompany(dto));
    }

    @PutMapping("/updateCompany")
    public ResponseEntity<BaseResponseDto> updateCompany(@RequestBody UpdateCompanyRequestDto dto){
        return ResponseEntity.ok(companyService.updateCompany(dto));
    }

    @DeleteMapping("/deleteCompany")
    public ResponseEntity<BaseResponseDto> deleteCompany(@RequestBody DeleteCompanyRequestDto dto){
        return ResponseEntity.ok(companyService.deleteCompany(dto));
    }

}
