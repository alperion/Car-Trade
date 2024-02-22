package com.example.demo.repository;

import com.example.demo.entity.HiredCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HiredCarRepository extends JpaRepository<HiredCar,String> {
    List<HiredCar> findByEndDateBefore(Date date);
    List<HiredCar> findAllByCarId(String carId);

}
