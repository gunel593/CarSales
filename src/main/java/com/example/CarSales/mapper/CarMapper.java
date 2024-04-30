package com.example.CarSales.mapper;

import com.example.CarSales.model.dto.Request.CarRequest;
import com.example.CarSales.model.dto.Responce.CarResponce;
import com.example.CarSales.model.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarMapper {
    CarMapper INSTANCE= Mappers.getMapper(CarMapper.class);
    List<CarResponce>toCarResponceList(List<Car> carList);
    CarResponce toCarResponce(Car car);
    Car toCar(CarRequest carRequest);
    Car toCarById(Long id,CarRequest carRequest );
}
