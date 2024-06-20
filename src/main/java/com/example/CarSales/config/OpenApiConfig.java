package com.example.CarSales.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI springShopOpenApi(){
        return new OpenAPI().info(new Info().title("learning spring service")
                .description("for learning spring framework"))
                .externalDocs(new ExternalDocumentation().description("no documentation")
                        .url("if you want doc,please connect with CarSales"));
    }
}
