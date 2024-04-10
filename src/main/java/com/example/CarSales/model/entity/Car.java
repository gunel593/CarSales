package com.example.CarSales.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private Long id;
    private String carModel;
    private String carCountry;
    private String carColour;
    private Integer carYear;
    private Long price;
}
