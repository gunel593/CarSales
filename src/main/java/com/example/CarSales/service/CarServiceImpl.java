 package com.example.CarSales.service;

import com.example.CarSales.mapper.CarMapper;
import com.example.CarSales.model.dto.Request.CarRequest;
import com.example.CarSales.model.dto.Responce.CarResponce;
import com.example.CarSales.model.entity.Car;
import com.example.CarSales.repository.CarMybatisRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
private final CarMybatisRepo carMybatisRepo;
private final CarMapper carMapper;



    @Override
    public List<CarResponce> getAllCars() {
        List<Car>cars =carMybatisRepo.findAll();
       List<CarResponce> carResponceList=carMapper.toCarResponceList(cars);
        return carResponceList;
    }

    @Override
    public CarResponce getByCarId(Long id) {
        Optional<Car>carOptional=carMybatisRepo.findById(id);
        return carOptional.map(carMapper::toCarResponce).orElse(null);

    }

    @Override
    public void insert(CarRequest carRequest) {
        log.info("Insert received.CarRequest:{}",carRequest);
        Car cars = carMapper.toCar(carRequest);
        log.info("carMapper mapped to to Car.Car:{}",cars);
        carMybatisRepo.insert(cars);
        log.info("Add process was succesfull.");
        log.warn("Just warning{}",carRequest);
        log.error("Just error.{}",carRequest);
    }

    @Override
    public void updateCar(Long id, CarRequest carRequest) {
     Car cars = carMapper.toCarById(id,carRequest);
     carMybatisRepo.updateCar(cars);
    }

    @Override
    public void deleteCar(Long id) {
     carMybatisRepo.deleteCar(id);
    }
}
