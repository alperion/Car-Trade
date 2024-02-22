package com.example.demo.service;

import com.example.demo.dto.request.users.AddMoneyToAccountRequestDto;
import com.example.demo.dto.request.users.UserLoginRequestDto;
import com.example.demo.dto.request.users.UserRegisterRequestDto;
import com.example.demo.dto.response.BaseResponseDto;
import com.example.demo.dto.response.car.GetCarField;
import com.example.demo.dto.response.car.GetCarsResponseDto;
import com.example.demo.dto.response.company.GetCompanyField;
import com.example.demo.dto.response.company.GetCompanyResponseDto;
import com.example.demo.dto.response.users.LoginResponseDto;
import com.example.demo.entity.Car;
import com.example.demo.entity.Company;
import com.example.demo.entity.Users;
import com.example.demo.exception.custom.EmailAlreadyExistException;
import com.example.demo.exception.custom.TokenNotValidException;
import com.example.demo.exception.custom.WrongMailException;
import com.example.demo.exception.custom.WrongPasswordException;
import com.example.demo.repository.UsersRepository;
import com.example.demo.utility.JwtManager;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final JwtManager jwtManager;
    private final CompanyService companyService;
    private final CarService carService;

    public UsersService(UsersRepository usersRepository, JwtManager jwtManager, @Lazy CompanyService companyService, CarService carService) {
        this.usersRepository = usersRepository;
        this.jwtManager = jwtManager;
        this.companyService = companyService;
        this.carService = carService;
    }

    public BaseResponseDto userRegister(UserRegisterRequestDto dto) {

        Optional<Users> users=usersRepository.findByEmail(dto.getEmail());

        if(users.isPresent()){
                throw new EmailAlreadyExistException(); // EMAIL_ALREADY_EXIST
        }

        Users users1=new Users();
        users1.setEmail(dto.getEmail());
        users1.setPassword(dto.getPassword());
        users1.setName(dto.getName());
        users1.setLastName(dto.getLastName());
        users1.setMoney(0);
        usersRepository.save(users1);
        BaseResponseDto baseResponseDto=new BaseResponseDto("kayıt başarılı ",200);

        return baseResponseDto;

    }

    public LoginResponseDto loginUser(UserLoginRequestDto dto){

        if(!usersRepository.existsByEmail(dto.getEmail())){
                throw new WrongMailException();//EMAIL_NOT_VALID
        }
        Optional<Users> users=usersRepository.findByEmail(dto.getEmail());
        if(!dto.getPassword().equals(users.get().getPassword())){
                throw new WrongPasswordException();// PASSWORD_NOT_VALID
        }

        Optional<String> token= jwtManager.createToken(users.get().getId(),users.get().getEmail());

        LoginResponseDto loginResponseDto=new LoginResponseDto(token.get(),"giriş yapıldı",200);

        return loginResponseDto;
    }


    public GetCompanyResponseDto getCompanies(String token) {

        Optional<String> id= jwtManager.getIdByToken(token);
        Optional<Users> users=usersRepository.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotValidException(); //TOKEN_NOT_VALID
        }

        List<GetCompanyField> companyFields=new ArrayList<>();
        List<Company> companies=companyService.getCompanies();

        for (Company company:companies){

            GetCompanyField getCompanyField=new GetCompanyField();
            getCompanyField.setName(company.getCompanyName());
            getCompanyField.setId(company.getId());
            companyFields.add(getCompanyField);
        }

        GetCompanyResponseDto getCompanyResponseDto=new GetCompanyResponseDto();
        getCompanyResponseDto.setCompanyFields(companyFields);

            return getCompanyResponseDto;

    }

    public GetCarsResponseDto getCars(String token, String companyId) {

        Optional<String> id= jwtManager.getIdByToken(token);
        if (id.isEmpty()){
            throw new TokenNotValidException(); //TOKEN_NOT_VALID
        }
        List<GetCarField> getCarFields=new ArrayList<>();
        List<Car> cars=carService.getCarsByCompanyId(companyId);

        for(Car car:cars){
            GetCarField getCarField=new GetCarField();

            getCarField.setCarId(car.getId());
            getCarField.setCarName(car.getCarName());
            getCarField.setCarCost(car.getCost());
            if(!car.isActivity()){
                getCarFields.add(getCarField);
            }
        }

        GetCarsResponseDto getCarsResponseDto=new GetCarsResponseDto();
        getCarsResponseDto.setGetCarFields(getCarFields);
        return getCarsResponseDto;

    }


    public Optional<Users> findById(String id){
        return usersRepository.findById(id);
    }

    public BaseResponseDto addMoneyToAccount(AddMoneyToAccountRequestDto dto) {

        Optional<String> id= jwtManager.getIdByToken(dto.getToken());
        Optional<Users> users=usersRepository.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotValidException(); //TOKEN_NOT_VALID
        }

        users.get().setMoney(dto.getMoney());

        usersRepository.save(users.get());

        BaseResponseDto baseResponseDto=new BaseResponseDto();
        baseResponseDto.setStatusCode(200);
        baseResponseDto.setMessage(dto.getMoney()+" tl hesabınıza eklendi");

        return baseResponseDto;
    }

    public void updateUser(Users users) {
        usersRepository.save(users);
    }
}
