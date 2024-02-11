package com.example.springrestapp.controller.car.response;

import com.example.springrestapp.model.Car;
import lombok.Data;

import java.util.List;

@Data
public class DeleteCarParamsResp {
    private List<Car> cars;
    private Integer amount;
}