package com.example.CarSales.model.dto.Responce;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("api")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestResponce {
    private Integer code;
    private String description;

}
