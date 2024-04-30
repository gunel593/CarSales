package com.example.CarSales.controller;

import com.example.CarSales.model.dto.Request.LoginRequest;
import com.example.CarSales.model.dto.Responce.LoginResponce;
import com.example.CarSales.model.dto.Request.RegistrRequest;
import com.example.CarSales.model.dto.Responce.UserResponce;
import com.example.CarSales.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<UserResponce>register(@RequestBody RegistrRequest registrRequest){
        UserResponce userResponce = userService.registr(registrRequest);
        return ResponseEntity.ok(userResponce);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponce>login(@RequestBody LoginRequest loginRequest){
                 LoginResponce loginResponce=userService.login(loginRequest);
        return ResponseEntity.ok(loginResponce);
    }
}
