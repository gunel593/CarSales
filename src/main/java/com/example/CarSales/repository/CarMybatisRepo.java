package com.example.CarSales.repository;

import com.example.CarSales.model.entity.Car;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CarMybatisRepo {
    List<Car>findAll();
    Optional<Car> findById(@Param("id")Long id);
    void insert(Car car);
    void updateCar(Car car);
    void deleteCar(@Param("id")Long id);

}
