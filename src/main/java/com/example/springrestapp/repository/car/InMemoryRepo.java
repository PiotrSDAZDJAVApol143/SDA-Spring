package com.example.springrestapp.repository.car;

import com.example.springrestapp.model.Car;
import com.example.springrestapp.model.FuelType;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Repository  //  - Tylko do nauki koment
public class InMemoryRepo implements CarRepository {
    public static final Map<String, Car> carMap;

    static {
//blok statyczny
        carMap = new HashMap<>();

        carMap.put("Abc1234", Car.builder()
                .brand("Audi")
                .model("A6")
                .productionYear(2014)
                .carValue(new BigDecimal(40000))
                .fuelType(FuelType.DIESEL)
                .build());
        carMap.put("Def5678", Car.builder()
                .brand("BMW")
                .model("3 Series")
                .productionYear(2018)
                .carValue(new BigDecimal(35000))
                .fuelType(FuelType.GASOLINE)
                .build());
        carMap.put("Ghi9012", Car.builder()
                .brand("Tesla")
                .model("Model S")
                .productionYear(2022)
                .carValue(new BigDecimal(80000))
                .fuelType(FuelType.ELECTRIC)
                .build());
        carMap.put("Jkl3456", Car.builder()
                .brand("Toyota")
                .model("Prius")
                .productionYear(2019)
                .carValue(new BigDecimal(30000))
                .fuelType(FuelType.HYBRID)
                .build());
        carMap.put("GWE4967", Car.builder()
                .brand("Toyota")
                .model("Auris")
                .productionYear(2007)
                .carValue(new BigDecimal(20000))
                .mileage(new BigDecimal(190000))
                .fuelType(FuelType.DIESEL)
                .build());
        carMap.put("Mno7890", Car.builder()
                .brand("Ford")
                .model("Fusion")
                .productionYear(2016)
                .carValue(new BigDecimal(25000))
                .fuelType(FuelType.LNG)
                .build());
        carMap.put("Pqr1234", Car.builder()
                .brand("Chevrolet")
                .model("Impala")
                .productionYear(2017)
                .carValue(new BigDecimal(30000))
                .fuelType(FuelType.LNG)
                .build());

    }

    @Override
    public List<Car> getAllCars() {
        return new ArrayList<>(carMap.values());
    }

    @Override
    public Optional<Car> getCarInfo(String plateNo) {
        return Optional.ofNullable(carMap.get(plateNo));
    }

    public List<Car> addCar(String plateNo, Car newCar) {
        carMap.put(plateNo, newCar);
        return new ArrayList<>(carMap.values());
    }


    @Override
    public Map<String, Car> updateCarValue(String plateNo, BigDecimal newCarValue) {
        Car car = carMap.get(plateNo);
        if (car != null) {
            car.setCarValue(newCarValue);
        }
        return carMap;
    }

    @Override
    public Map<String, Car> updateCarMileage(String plateNo, BigDecimal newMileage) {
        Car car = carMap.get(plateNo);
        if (car != null) {
                car.setMileage(newMileage);
        }
        return carMap;
    }

  @Override
 // public List<Car> findByProductionYear(Integer startYear, Integer endYear) {
 //     List<Car> result = new ArrayList<>();
 //     for (int year = startYear; year <= endYear; year++) {
 //         List<Car> cars = carMapList.get(year);
 //         if (cars != null) {
 //             result.addAll(cars);
 //         }
 //     }
 //     return result;
 // }
  public List<Car> findByProductionYear(Integer startYear, Integer endYear) {
      return carMap.values().stream()
              .filter(car -> car.getProductionYear() >= startYear && car.getProductionYear() <= endYear)
              .collect(Collectors.toList());
  }

    @Override
    public List<Car> findByFuelType(FuelType fuelType) {
        return carMap.values().stream()
                .filter(car->car.getFuelType().equals(fuelType))
                .collect(Collectors.toList());
    }


    @Override
    public Optional<Car> deleteCar(String plateNo) {
        return Optional.ofNullable(carMap.remove(plateNo));
    }

    @Override
    public List<Car> deleteByParams(String model, String brand) {
        carMap.entrySet()
                .removeIf(entry -> entry.getValue().getModel().equals(model) && entry.getValue().getBrand().equals(brand));

        return new ArrayList<>(carMap.values());
    }




}
