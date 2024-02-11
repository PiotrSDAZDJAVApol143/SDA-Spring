package com.example.springrestapp.repository.car;

import com.example.springrestapp.model.Car;
import com.example.springrestapp.model.FuelType;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface CarRepository {
    List<Car> getAllCars();

    Optional <Car> getCarInfo(String plateNo);
    List<Car> addCar(String plateNo, Car newCar);

    Map<String,Car> updateCarValue(String plateNo, BigDecimal newCarValue);

    Map<String,Car> updateCarMileage(String plateNo, BigDecimal newMileage);

    List<Car> findByProductionYear(Integer startYear, Integer endYear);

    List<Car> findByFuelType(FuelType fuelType);

    Optional<Car> deleteCar(String plateNo);

    List<Car> deleteByParams(String model, String brand);



}
