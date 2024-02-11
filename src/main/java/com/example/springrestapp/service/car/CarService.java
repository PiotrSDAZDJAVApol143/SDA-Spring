package com.example.springrestapp.service.car;

import com.example.springrestapp.model.Car;

import com.example.springrestapp.model.FuelType;
import com.example.springrestapp.repository.car.CarRepository;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service //-- Tylko do nauki koment

public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars(){
        return carRepository.getAllCars();
    }

    public Optional<Car> getCarByPlateNo(String plateNo){
        return carRepository.getCarInfo(plateNo);
    }

    public Optional<Car> getCarInfo(String plateNo) {
        return carRepository.getCarInfo(plateNo);
    }
    public List<Car> addCar(String plateNo, Car newCar) {
        return carRepository.addCar(plateNo, newCar);
    }
    public Map<String, Car> updateCarValue(String plateNo, BigDecimal newCarValue) {
        return carRepository.updateCarValue(plateNo, newCarValue);
    }
    public Map<String, Car> updateCarMileage(String plateNo, BigDecimal newMileage) {
        return carRepository.updateCarMileage(plateNo, newMileage);
    }
    public List<Car> findByProductionYear(Integer startYear, Integer endYear) {
        return carRepository.findByProductionYear(startYear, endYear);
    }
    public List<Car> findByFuelType(FuelType fuelType){
        return carRepository.findByFuelType(fuelType);
    }
    // -------- wariant 2 ----------
    public List<Car> getByFuelType(String fuelType) {
        return carRepository.findByFuelType(FuelType.valueOf(fuelType));
    }
    public Optional<Car> deleteCar(String plateNo){
        return carRepository.deleteCar(plateNo);
    }

    public List<Car> deleteByParams(String model, String brand) {
        return carRepository.deleteByParams(model, brand);
    }



}
