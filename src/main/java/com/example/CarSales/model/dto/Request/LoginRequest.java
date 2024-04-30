package com.example.CarSales.model.dto.Request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;


}
