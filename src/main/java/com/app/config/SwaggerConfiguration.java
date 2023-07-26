package com.app.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI configDoc(){
        return new OpenAPI()
                .info(new Info()
                        .title("Book-Api")
                        .version("1.0.0")
                        .description("Esta API permite realizar operaciones básicas sobre los " +
                                "libros almacenados en una base de datos de libros."));
    }
}
