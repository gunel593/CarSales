package com.example.CarSales.controller;

import com.example.CarSales.model.dto.Request.CarRequest;
import com.example.CarSales.model.dto.Responce.CarResponce;
import com.example.CarSales.service.CarService;
import com.example.CarSales.service.CarServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car-sales")
public class CarController {
    private final CarService carService;

    public CarController(@Qualifier("carJpaServiceImpl") CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public ResponseEntity<List<CarResponce>> getAllCars(){
    List<CarResponce>cars= carService.getAllCars();
    return ResponseEntity.ok(cars);
}
    @GetMapping("/no-auth/id/{id}")
    public ResponseEntity <CarResponce> getAllCarsById(@PathVariable("id")Long id){
        CarResponce car= carService.getByCarId(id);
        return ResponseEntity.ok(car);
    }
    @PostMapping
    public ResponseEntity <Void> addCars(@RequestBody CarRequest carRequest) {
        carService.insert(carRequest);
        return ResponseEntity.ok().build();
    }
    @PutMapping("id/{id}")
    public ResponseEntity <Void> updateCarById(@PathVariable("id")Long id,
                                               @RequestBody CarRequest carRequest){
        carService.updateCar(id,carRequest);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/admin/id/{id}")
    public ResponseEntity <Void> deleteCarById(@PathVariable("id")Long id){
        carService.deleteCar(id);
        return ResponseEntity.ok().build();
    }
}
