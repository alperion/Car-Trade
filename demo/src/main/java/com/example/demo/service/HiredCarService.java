package com.example.demo.service;

import com.example.demo.dto.request.hiredcar.HireCarRequestDto;
import com.example.demo.dto.response.BaseResponseDto;
import com.example.demo.entity.Car;
import com.example.demo.entity.HiredCar;
import com.example.demo.entity.Users;
import com.example.demo.exception.custom.MoneyNotEnoughException;
import com.example.demo.exception.custom.TokenNotValidException;
import com.example.demo.repository.HiredCarRepository;
import com.example.demo.utility.JwtManager;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HiredCarService {

    private final HiredCarRepository hiredCarRepository;
    private final CarService carService;
    private final JwtManager jwtManager;
    private  final UsersService usersService;


    public HiredCarService(HiredCarRepository hiredCarRepository, CarService carService, JwtManager jwtManager, UsersService usersService) {
        this.hiredCarRepository = hiredCarRepository;
        this.carService = carService;
        this.jwtManager = jwtManager;
        this.usersService = usersService;
    }

    public BaseResponseDto hireCar(HireCarRequestDto dto){
        Optional<String> id= jwtManager.getIdByToken(dto.getToken());
        Optional<Users> users=usersService.findById(id.get());
        int day=dto.getDay();
        Long expireTime=1000*20l*day;
        if (id.isEmpty()){
            throw new TokenNotValidException(); //TOKEN_NOT_VALID
        }

        Car car=carService.getCarById(dto.getCarId()).get();

        if(users.get().getMoney()<((car.getCost())*day)){
            throw new MoneyNotEnoughException(); // MONEY_IS_NOT_ENOUGH
        }

        HiredCar hiredCar=new HiredCar();
        hiredCar.setUserId(id.get());
        hiredCar.setCarId(dto.getCarId());
        hiredCar.setHiredDate(new Date(System.currentTimeMillis()));
        hiredCar.setEndDate(new Date(System.currentTimeMillis()+expireTime));

        hiredCarRepository.save(hiredCar);

        car.setActivity(true);
        carService.updateCar(car);
        users.get().setMoney(users.get().getMoney()-((car.getCost())*day));
        usersService.updateUser(users.get());

        BaseResponseDto baseResponseDto=new BaseResponseDto();
        baseResponseDto.setStatusCode(200);
        baseResponseDto.setMessage(new Date(System.currentTimeMillis()+expireTime)+" süresi kadar kiralamıştır");

        return baseResponseDto;
    }



    public List<HiredCar> expireddCar(){
        List<HiredCar> hiredCars=hiredCarRepository.findByEndDateBefore(new Date(System.currentTimeMillis()));
        return hiredCars;
    }

    public void delete(HiredCar hiredCar) {

        hiredCarRepository.delete(hiredCar);

    }
    public List<HiredCar> findAllByCarId(String carId){

        return hiredCarRepository.findAllByCarId(carId);
    }

}
