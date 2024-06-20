package com.example.CarSales.controller;

import com.example.CarSales.model.dto.Responce.TestResponce;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
@Slf4j
@RestController
@RequestMapping("test")
@RequiredArgsConstructor
public class TestController {
    private final WebClient webClient;

    @GetMapping("web-flux")
    public ResponseEntity<TestResponce>testWebFlux(){
        log.info("calling test api");
     TestResponce testResponce=webClient.get().
             uri("http://localhost:5000/api/test")
             .retrieve().bodyToMono(TestResponce.class)
            .block();
     log.info("api called.response:{}",testResponce);
     return  ResponseEntity.ok(testResponce);
    }
}
