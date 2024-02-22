package com.example.demo.controller;

import com.example.demo.dto.request.car.AddCarRequestDto;
import com.example.demo.dto.request.car.DeleteCarRequestDto;
import com.example.demo.dto.request.car.UpdateCarRequestDto;
import com.example.demo.dto.response.BaseResponseDto;
import com.example.demo.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;
    public CarController(CarService carService) {
        this.carService = carService;
    }



    @PostMapping("/addCar")
    public ResponseEntity<BaseResponseDto> addCar(@RequestBody AddCarRequestDto dto){
          return ResponseEntity.ok(carService.addCar(dto));
    }

    @DeleteMapping("/deleteCar")
    public ResponseEntity<BaseResponseDto> deleteCar(@RequestBody DeleteCarRequestDto dto){
            return ResponseEntity.ok(carService.deleteCarById(dto));
    }

    @PutMapping("/updateCar")
    public ResponseEntity<BaseResponseDto> updateCar(@RequestBody UpdateCarRequestDto dto){
        return ResponseEntity.ok(carService.updateCarField(dto));
    }

}
