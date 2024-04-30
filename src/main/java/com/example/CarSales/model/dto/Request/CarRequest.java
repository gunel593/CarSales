package com.example.CarSales.model.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarRequest {
    private Long id;
    private String carModel;
    private String carCountry;
    private String carColour;
    private Integer carYear;
    private Long price;
}
