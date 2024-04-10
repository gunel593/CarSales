package com.example.CarSales.controller;

import com.example.CarSales.model.dto.CarRequest;
import com.example.CarSales.model.dto.CarResponce;
import com.example.CarSales.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car-sales")
@RequiredArgsConstructor
public class CarController {
    private final CarService carServise;
@GetMapping
    public ResponseEntity<List<CarResponce>> getAllCars(){
    List<CarResponce>cars= carServise.getAllCars();
    return ResponseEntity.ok(cars);
}
    @GetMapping("id/{id}")
    public ResponseEntity <CarResponce> getAllCarsById(@PathVariable("id")Long id){
        CarResponce car= carServise.getByCarId(id);
        return ResponseEntity.ok(car);
    }
    @PostMapping
    public ResponseEntity <Void> addCars(@RequestBody CarRequest carRequest) {
        carServise.insert(carRequest);
        return ResponseEntity.ok().build();
    }
    @PutMapping("id/{id}")
    public ResponseEntity <Void> updateCarById(@PathVariable("id")Long id,
                                               @RequestBody CarRequest carRequest){
        carServise.updateCar(id,carRequest);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("id/{id}")
    public ResponseEntity <Void> deleteCarById(@PathVariable("id")Long id){
        carServise.deleteCar(id);
        return ResponseEntity.ok().build();
    }
}
