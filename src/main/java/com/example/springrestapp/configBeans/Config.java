package com.example.springrestapp.configBeans;

import com.example.springrestapp.configuration.WorkshopInfo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
//    @Bean
//    public CarRepository carRepository() {
//        return new InMemoryRepo();
//    }
//
//    @Bean
//    public CarService carService(CarRepository carRepository) {
//        return new CarService(carRepository);
//    }
//
    @Bean
    public WorkshopInfo workshopInfo(){
        return new WorkshopInfo();
    }
}
