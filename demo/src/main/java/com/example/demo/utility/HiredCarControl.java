package com.example.demo.utility;


import com.example.demo.entity.Car;
import com.example.demo.entity.HiredCar;
import com.example.demo.service.CarService;
import com.example.demo.service.HiredCarService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


import java.util.List;

@Configuration
@EnableScheduling
public class HiredCarControl {

    private final HiredCarService hiredCarService;
    private final CarService carService;

    public HiredCarControl(HiredCarService hiredCarService, CarService carService) {
        this.hiredCarService = hiredCarService;
        this.carService = carService;
    }

    @Scheduled(fixedRate = 20000)
    public void expiredCarController(){
        List<HiredCar>expiredCars=hiredCarService.expireddCar();
        System.err.println("mum");

        for(HiredCar hiredCar:expiredCars){
            Car car=carService.getCarById(hiredCar.getCarId()).get();
            if(car.isActivity()){

                car.setActivity(false);
                carService.updateCar(car);
            }
        }
    }


}
