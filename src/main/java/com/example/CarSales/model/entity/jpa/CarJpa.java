package com.example.CarSales.model.entity.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serial;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car_jpa")
public class CarJpa {
    @Serial
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "carModel")
    private String carModel;

    @Column(name = "carCountry")
    private String carCountry;

    @Column(name = "carColour")
    private String carColour;

    @Column(name = "carYear")
    private Integer carYear;

    @Column(name = "price")
    private Long price;
}

