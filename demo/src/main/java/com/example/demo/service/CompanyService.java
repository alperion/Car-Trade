package com.example.demo.service;

import com.example.demo.dto.request.company.UpdateCompanyRequestDto;
import com.example.demo.dto.request.company.AddCompanyRequestDto;
import com.example.demo.dto.request.company.DeleteCompanyRequestDto;
import com.example.demo.dto.response.BaseResponseDto;
import com.example.demo.entity.Car;
import com.example.demo.entity.Company;
import com.example.demo.entity.HiredCar;
import com.example.demo.entity.Users;
import com.example.demo.exception.custom.InvalidRoleException;
import com.example.demo.exception.custom.TokenNotValidException;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.utility.JwtManager;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final JwtManager jwtManager;
    private final UsersService usersService;

    private final CarService carService;
    private final HiredCarService hiredCarService;
    public CompanyService(CompanyRepository companyRepository, JwtManager jwtManager,  UsersService usersService,@Lazy CarService carService, HiredCarService hiredCarService) {
        this.companyRepository = companyRepository;
        this.jwtManager = jwtManager;
        this.usersService = usersService;
        this.carService = carService;
        this.hiredCarService = hiredCarService;
    }

    public List<Company> getCompanies(){

            return companyRepository.findAll();

    }

    public BaseResponseDto addCompany(AddCompanyRequestDto dto){
        Optional<String> id= jwtManager.getIdByToken(dto.getToken());
        Optional<Users> users=usersService.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotValidException(); //TOKEN_NOT_VALID
        }

        Company company=new Company();
        company.setCompanyName(dto.getCompanyName());
        company.setUserId(users.get().getId());

        companyRepository.save(company);

        BaseResponseDto baseResponseDto=new BaseResponseDto();
        baseResponseDto.setMessage("Şirket Eklendi");
        baseResponseDto.setStatusCode(200);

        return baseResponseDto;

    }

    public Optional<Company> findByCompanyId(String companyId) {
        return companyRepository.findById(companyId);
    }

    public BaseResponseDto updateCompany(UpdateCompanyRequestDto dto) {

        Optional<String> id= jwtManager.getIdByToken(dto.getToken());
        Optional<Company> company=companyRepository.findById(dto.getCompanyId());
        if (id.isEmpty()){
            throw new TokenNotValidException(); //TOKEN_NOT_VALID
        }
        if(!id.get().equals(company.get().getUserId())){
            throw new InvalidRoleException();// ACCESS_ERROR
        }

        company.get().setCompanyName(dto.getCompanyName());
        companyRepository.save(company.get());

        BaseResponseDto baseResponseDto=new BaseResponseDto();
        baseResponseDto.setMessage("isim güncellendi");
        baseResponseDto.setStatusCode(200);
        return baseResponseDto;
    }


    public BaseResponseDto deleteCompany(DeleteCompanyRequestDto dto) {

        Optional<String> id= jwtManager.getIdByToken(dto.getToken());
        Optional<Company> company=companyRepository.findById(dto.getCompanyId());
        if (id.isEmpty()){
            throw new TokenNotValidException(); //TOKEN_NOT_VALID
        }
        if(!id.get().equals(company.get().getUserId())){
            throw new InvalidRoleException();// ACCESS_ERROR
        }
        List<Car> cars=carService.getCarsByCompanyId(dto.getCompanyId());
        List<HiredCar> hiredCars=new ArrayList<>();

        for (Car car :cars){
            for (HiredCar hiredCar:hiredCarService.findAllByCarId(car.getId())){
                hiredCars.add(hiredCar);
            }
        }
        for (HiredCar hiredCar:hiredCars){
            hiredCarService.delete(hiredCar);
        }
        for (Car car:cars){

            carService.deleteCar(car);
        }
        companyRepository.deleteById(company.get().getId());

        BaseResponseDto baseResponseDto=new BaseResponseDto();
        baseResponseDto.setMessage("Şirket silindi");
        baseResponseDto.setStatusCode(200);

        return baseResponseDto;

    }
}
