package com.example.CarSales.service;

import com.example.CarSales.model.dto.CarRequest;
import com.example.CarSales.model.dto.CarResponce;

import java.util.List;

public interface CarService {
    List<CarResponce> getAllCars();
    CarResponce getByCarId(Long id);
    void insert(CarRequest carRequest);
    void updateCar(Long id,CarRequest carRequest);
    void deleteCar(Long id);

}
