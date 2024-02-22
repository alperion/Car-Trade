package com.example.demo.controller;

import com.example.demo.dto.request.users.AddMoneyToAccountRequestDto;
import com.example.demo.dto.request.users.UserLoginRequestDto;
import com.example.demo.dto.request.users.UserRegisterRequestDto;
import com.example.demo.dto.response.BaseResponseDto;
import com.example.demo.dto.response.car.GetCarsResponseDto;
import com.example.demo.dto.response.company.GetCompanyResponseDto;
import com.example.demo.dto.response.users.LoginResponseDto;
import com.example.demo.service.UsersService;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;


    public UsersController(UsersService usersService) {
        this.usersService = usersService;

    }
    @PostMapping("/register")
    public ResponseEntity<BaseResponseDto> userRegister(@RequestBody UserRegisterRequestDto dto){
            return ResponseEntity.ok(usersService.userRegister(dto));
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> userLogin(@RequestBody UserLoginRequestDto dto){
        return ResponseEntity.ok(usersService.loginUser(dto));
    }


    @GetMapping("/getCompanies/{token}")
    public ResponseEntity<GetCompanyResponseDto> getCarCompanies(@PathVariable String token){
        return ResponseEntity.ok(usersService.getCompanies(token));
    }

    @GetMapping("/getCars/{token}/{companyId}")
    public ResponseEntity<GetCarsResponseDto> getCars(@PathVariable String token, @PathVariable String companyId){
            return ResponseEntity.ok(usersService.getCars(token,companyId));
    }

    @PutMapping("/addMoney")
    public ResponseEntity<BaseResponseDto> addMoney(@RequestBody AddMoneyToAccountRequestDto dto){
            return ResponseEntity.ok(usersService.addMoneyToAccount(dto));
    }





}
