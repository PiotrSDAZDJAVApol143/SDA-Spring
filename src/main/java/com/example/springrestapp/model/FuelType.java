package com.example.springrestapp.model;

import lombok.Getter;

@Getter
public enum FuelType {
    GASOLINE("benzyna"),
    DIESEL("diesel"),
    ELECTRIC("elektryk"),
    HYBRID("hybryda"),
    LNG("gas");

    private final String name;

    FuelType(String name) {
        this.name = name;
    }



}
