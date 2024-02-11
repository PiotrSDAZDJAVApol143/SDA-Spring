package com.example.springrestapp.controller.car;

import com.example.springrestapp.controller.car.request.DeleteCarParamsReq;
import com.example.springrestapp.controller.car.response.DeleteCarParamsResp;
import com.example.springrestapp.model.Car;
import com.example.springrestapp.model.FuelType;
import com.example.springrestapp.service.car.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
@Slf4j
public class CarController {

    private final CarService carService;

  //  @Autowired
  //  public CarController(CarRepository carRepository) {
  //      this.carService = new CarService(carRepository);
  //  }

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars() {
        log.info("Otrzymalismy request wyszukiwania aut ");
        List<Car> allCars2 = carService.getAllCars();
        return ResponseEntity.ok(allCars2);
    }

    @GetMapping("/path/{plateNo}")
    public ResponseEntity<String> witPathVariable(@PathVariable String plateNo) {
        return ResponseEntity.ok("Numer rejestracji: " + plateNo);
    }

    @GetMapping("/plateNo")
    public ResponseEntity<Car> getCarByPlateNo(@RequestParam String plateNo) {
        log.info("Otrzymalismy request wyszukiwania aut ");
        return carService.getCarByPlateNo(plateNo)
                .map(optCar -> ResponseEntity.ok(optCar))
                .orElse(null);
    }

    @PostMapping("/{number}")
    public ResponseEntity<List<Car>> addCar(@PathVariable String number, @RequestBody @Valid Car car) {
      //  Optional<Car> existingCar = carService.getCarInfo(number);
      //  if (existingCar.isPresent()) {
           // log.info("Car is on the list: " + number);
            //return ResponseEntity.status(HttpStatus.CONFLICT).build();
            //throw new OwnCarExceptions("Konflikt: " + number + " już istnieje");
       // }
      //  List<Car> updatedCars = carService.addCar(number, car);
        return ResponseEntity.ok(carService.addCar(number,car));
    }

    @PatchMapping("/updateCarValue/{plateNo}")
    public ResponseEntity<Map<String, Car>> updateCarValue(@PathVariable String plateNo, @RequestBody BigDecimal newCarValue) {
        return ResponseEntity.ok(carService.updateCarValue(plateNo, newCarValue));
    }
    @PatchMapping("/updateMileage/{plateNo}")
    public ResponseEntity<Map<String,Car>> updateCarMileage(@PathVariable String plateNo, @RequestBody BigDecimal newMileage){
        return ResponseEntity.ok(carService.updateCarMileage(plateNo, newMileage));
    }
    @GetMapping("/searchByYear/{startYear}-{endYear}")
    public List<Car> getCarsByProductionYear(@PathVariable("startYear") Integer startYear, @PathVariable("endYear") Integer endYear) {
        return carService.findByProductionYear(startYear, endYear);
    }

    @GetMapping("/searchByFuelType/{fuel}")
    public List<Car> getCarsByFuelType(@PathVariable FuelType fuel){
        return carService.findByFuelType(fuel);
    }
    // ---------- wariant 2 --------------
    @GetMapping("/fuel/{fuelType}")
    public ResponseEntity<List<Car>> getByFuelType(@PathVariable String fuelType) {
        return ResponseEntity.ok(carService.getByFuelType(fuelType.toUpperCase()));
    }


    @DeleteMapping("/delete/{plateNo}")
    public ResponseEntity<Car> deleteCarByPlate(@PathVariable String plateNo) {
        return carService.deleteCar(plateNo)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/delete")
    public ResponseEntity<DeleteCarParamsResp> deleteByParams(@RequestBody DeleteCarParamsReq params) {
        DeleteCarParamsResp response = new DeleteCarParamsResp();
        List<Car> cars = carService.deleteByParams(params.getModel(), params.getBrand());

        response.setAmount(cars.size());
        response.setCars(cars);

        return ResponseEntity.ok(response);
    }

}

