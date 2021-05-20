package com.example.p2.car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarRestController {

    @Autowired
    private CarService carService;

    @PostMapping("/cars" )
    public ResponseEntity<Car> createCar(@RequestBody Car Car) {
        HttpStatus status = HttpStatus.CREATED;
        Car saved = carService.save(Car);
        return new ResponseEntity<>(saved, status);
    }

    @GetMapping(path="/cars")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/car/{maker}/{model}")
    public ResponseEntity<Car> getCarDetails
            (@PathVariable(value = "maker") String maker, @PathVariable(value = "model") String model) {
        return new ResponseEntity<>(carService.getCarByMakerAndModel(maker,model),HttpStatus.OK);
    }

}
