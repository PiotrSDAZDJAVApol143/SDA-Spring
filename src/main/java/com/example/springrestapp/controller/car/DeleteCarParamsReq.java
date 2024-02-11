package com.example.springrestapp.controller.car.request;


import lombok.Data;

@Data
public class DeleteCarParamsReq {
    private String model;
    private String brand;
}