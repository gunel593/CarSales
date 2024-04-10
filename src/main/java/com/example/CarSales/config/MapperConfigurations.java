package com.example.CarSales.config;

import com.example.CarSales.mapper.CarMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfigurations {
    @Bean
    public CarMapper carMapper(){

        return CarMapper.INSTANCE;
    }
}
