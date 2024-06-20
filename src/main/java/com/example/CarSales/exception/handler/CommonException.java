package com.example.CarSales.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommonException extends RuntimeException{
    private String code;
    private String destriction;
    private HttpStatusCode httpStatusCode;
}
