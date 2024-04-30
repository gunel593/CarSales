package com.example.CarSales.service;

import com.example.CarSales.model.dto.Request.LoginRequest;
import com.example.CarSales.model.dto.Request.RegistrRequest;
import com.example.CarSales.model.dto.Responce.LoginResponce;
import com.example.CarSales.model.dto.Responce.UserResponce;
import com.example.CarSales.model.entity.User;

import java.util.Optional;


public interface UserService {

    UserResponce registr(RegistrRequest registrRequest);
    LoginResponce login(LoginRequest loginRequest);
    Optional<User> getByUsername(String username);
}
