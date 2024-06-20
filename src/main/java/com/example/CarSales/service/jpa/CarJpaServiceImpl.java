 package com.example.CarSales.service.jpa;

import com.example.CarSales.exception.handler.CommonException;
import com.example.CarSales.mapper.CarMapper;
import com.example.CarSales.model.dto.Request.CarRequest;
import com.example.CarSales.model.dto.Responce.CarResponce;
import com.example.CarSales.model.entity.Car;
import com.example.CarSales.model.entity.jpa.CarJpa;
import com.example.CarSales.repository.CarMybatisRepo;
import com.example.CarSales.repository.jpa.CarJpaMybatis;
import com.example.CarSales.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

 @Slf4j
 @Service
 @RequiredArgsConstructor
 public class CarJpaServiceImpl implements CarService {
 private final CarJpaMybatis carJpaMybatis;
 private final CarMapper carMapper;



     @Override
     public List<CarResponce> getAllCars() {
         List<CarJpa>cars =carJpaMybatis.findAll();
        List<CarResponce> carResponceList=carMapper.toCarResponceListJpa(cars);
         return carResponceList;
     }

     @Override
     public CarResponce getByCarId(Long id) {
         Optional<CarJpa>carOptional=carJpaMybatis.findById(id);
         return carOptional.map(carMapper::toCarResponceJpa).orElse(null);

     }

     @Override
     public void insert(CarRequest carRequest) {
         log.info("Insert received.CarRequest:{}",carRequest);
         CarJpa carJpa = carMapper.toCarJpa(carRequest);
         log.info("carMapper mapped to to Car.Car:{}",carJpa);
         carJpaMybatis.save(carJpa);
         log.info("Add process was succesfull.");
         log.warn("Just warning{}",carRequest);
         log.error("Just error.{}",carRequest);
     }

     @Override
     public void updateCar(Long id, CarRequest carRequest) {
      CarJpa carJpa = carMapper.toCarByIdJpa(id,carRequest);
      carJpaMybatis.save(carJpa);
     }

     @Override
     public void deleteCar(Long id) {
       CarJpa carJpa=carJpaMybatis.findById(id).orElseThrow(()->new CommonException("1200","no entity with  id", HttpStatus.BAD_REQUEST));
      carJpaMybatis.delete(carJpa);
     }
 }
