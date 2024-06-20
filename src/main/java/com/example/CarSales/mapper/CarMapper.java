package com.example.CarSales.mapper;

import com.example.CarSales.model.dto.Request.CarRequest;
import com.example.CarSales.model.dto.Responce.CarResponce;
import com.example.CarSales.model.entity.Car;
import com.example.CarSales.model.entity.jpa.CarJpa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring",imports={LocalDateTime.class})
public interface CarMapper {
 //   CarMapper INSTANCE= Mappers.getMapper(CarMapper.class);
    List<CarResponce>toCarResponceList(List<Car> carList);
    List<CarResponce>toCarResponceListJpa(List<CarJpa> carList);
    CarResponce toCarResponce(Car car);
    CarResponce toCarResponceJpa(CarJpa carJpa);
    Car toCar(CarRequest carRequest);
    CarJpa toCarJpa(CarRequest carRequest);
    Car toCarById(Long id,CarRequest carRequest );
    CarJpa toCarByIdJpa(Long id,CarRequest carRequest );
}
