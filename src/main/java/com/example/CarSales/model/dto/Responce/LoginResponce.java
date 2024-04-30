package com.example.CarSales.model.dto.Responce;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data

public class LoginResponce {
    private String responce;
    private String token;
    public static LoginResponce withToken(String token){
        LoginResponce loginResponce= new LoginResponce();
        loginResponce.setToken(token);
        return loginResponce;
    }

    public static LoginResponce withResponce(String responce){
        LoginResponce loginResponce= new LoginResponce();
        loginResponce.setResponce(responce);
        return loginResponce;
    }
}