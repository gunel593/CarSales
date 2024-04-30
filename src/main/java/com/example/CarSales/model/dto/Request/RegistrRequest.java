package com.example.CarSales.model.dto.Request;

import lombok.Data;

@Data
public class RegistrRequest {
    private String username;
    private Long id;
    private String password;
    private String confirmPassword;
    private String name;
}
