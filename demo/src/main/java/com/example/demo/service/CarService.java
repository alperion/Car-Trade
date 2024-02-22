package com.example.demo.service;

import com.example.demo.dto.request.car.AddCarRequestDto;
import com.example.demo.dto.request.car.DeleteCarRequestDto;
import com.example.demo.dto.request.car.UpdateCarRequestDto;
import com.example.demo.dto.response.BaseResponseDto;
import com.example.demo.entity.Car;
import com.example.demo.entity.Company;
import com.example.demo.entity.HiredCar;
import com.example.demo.entity.Users;
import com.example.demo.exception.custom.CompanyNotExistException;
import com.example.demo.exception.custom.InvalidRoleException;
import com.example.demo.exception.custom.TokenNotValidException;
import com.example.demo.repository.CarRepository;
import com.example.demo.utility.JwtManager;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final JwtManager jwtManager;
    private final UsersService usersService;
    private final CompanyService companyService;
    private final HiredCarService hiredCarService;

    public CarService(CarRepository carRepository, JwtManager jwtManager, @Lazy UsersService usersService, @Lazy CompanyService companyService,@Lazy HiredCarService hiredCarService) {
        this.carRepository = carRepository;
        this.jwtManager = jwtManager;
        this.usersService = usersService;
        this.companyService = companyService;
        this.hiredCarService = hiredCarService;
    }

    public List<Car> getCarsByCompanyId(String companyId) {
        return carRepository.findAllByCompanyId(companyId);

    }
    public BaseResponseDto addCar(AddCarRequestDto dto){

        Optional<String> id= jwtManager.getIdByToken(dto.getToken());
        Optional<Company> company=companyService.findByCompanyId(dto.getCompanyId());
        if (id.isEmpty()){
            throw new TokenNotValidException(); //TOKEN_NOT_VALID
        }
        if(company.isEmpty()){
            throw new CompanyNotExistException();//COMPANY_NOT_EXIST
        }
        if (!company.get().getUserId().equals(id.get())){
            throw new InvalidRoleException(); // ACCESS_ERROR
        }
        Car car=new Car();
        car.setCarName(dto.getName());
        car.setActivity(false);
        car.setCost(dto.getCost());
        car.setCompanyId(dto.getCompanyId());

        carRepository.save(car);

        BaseResponseDto baseResponseDto=new BaseResponseDto();
        baseResponseDto.setStatusCode(200);
        baseResponseDto.setMessage("Şirkete yeni bir araba eklendi ");

        return baseResponseDto;

    }

    public Optional<Car> getCarById(String id){
        return carRepository.findById(id);
    }


    public void updateCar(Car car) {
        carRepository.save(car);
    }
    public void deleteCar(Car car){
            carRepository.delete(car);
    }

    public BaseResponseDto deleteCarById(DeleteCarRequestDto dto) {
        Optional<String> id= jwtManager.getIdByToken(dto.getToken());
        Optional<Company> company=companyService.findByCompanyId(carRepository.findById(dto.getCarId()).get().getCompanyId());
        if (id.isEmpty()){
            throw new TokenNotValidException(); //TOKEN_NOT_VALID
        }
        if(!id.get().equals(company.get().getUserId())){
            throw new InvalidRoleException();// ACCESS_ERROR
        }

        Optional<Car> car=carRepository.findById(dto.getCarId());
        for (HiredCar hiredCar:hiredCarService.findAllByCarId(car.get().getId())){
            hiredCarService.delete(hiredCar);
        }
        carRepository.delete(car.get());
            BaseResponseDto baseResponseDto=new BaseResponseDto();
            baseResponseDto.setStatusCode(200);
            baseResponseDto.setMessage("Araba silindi");
            return baseResponseDto;
    }

    public BaseResponseDto updateCarField(UpdateCarRequestDto dto) {
        Optional<String> id= jwtManager.getIdByToken(dto.getToken());
        Optional<Company> company=companyService.findByCompanyId(carRepository.findById(dto.getCarId()).get().getCompanyId());
        if (id.isEmpty()){
            throw new TokenNotValidException(); //TOKEN_NOT_VALID
        }
        if(!id.get().equals(company.get().getUserId())){
            throw new InvalidRoleException();// ACCESS_ERROR
        }

        Car car =carRepository.findById(dto.getCarId()).get();
        int cost=dto.getCost();
        String carName=dto.getName();
        if(cost<0 || cost==0){
            cost=20000;
        }
        if (carName.length()<2){
            carName="no-name";
        }
        car.setCarName(carName);
        car.setCost(cost);
        carRepository.save(car);



        BaseResponseDto baseResponseDto=new BaseResponseDto();
        baseResponseDto.setMessage("Araba alanları güncellendi");
        baseResponseDto.setStatusCode(200);

            return baseResponseDto;

    }
}
