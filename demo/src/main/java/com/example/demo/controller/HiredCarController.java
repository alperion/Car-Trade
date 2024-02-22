package com.example.demo.controller;

import com.example.demo.dto.request.hiredcar.HireCarRequestDto;
import com.example.demo.dto.response.BaseResponseDto;
import com.example.demo.service.HiredCarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hiredcar")
public class HiredCarController {

    private final HiredCarService hiredCarService;

    public HiredCarController(HiredCarService hiredCarService) {
        this.hiredCarService = hiredCarService;
    }

    @PostMapping("/hireNewCar")
    public ResponseEntity<BaseResponseDto> hireCar(@RequestBody HireCarRequestDto dto){
            return ResponseEntity.ok(hiredCarService.hireCar(dto));
    }

}
