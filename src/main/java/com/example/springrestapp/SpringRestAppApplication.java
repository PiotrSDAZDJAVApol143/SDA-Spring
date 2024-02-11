package com.example.springrestapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Moja aplikacja",
                version = "1.0.0"
        )
)
public class SpringRestAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestAppApplication.class, args);
    }
//architektura trójwarstowa

}
