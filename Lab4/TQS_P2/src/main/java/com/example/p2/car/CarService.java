package com.example.p2.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public Car getCarById(Long id){return carRepository.findById(id).orElse(null);}
    public Car getCarByMakerAndModel(String maker, String model){return carRepository.findByMakerAndModel(maker,model);}
    public List<Car> getAllCars(){return carRepository.findAll();}

    public Car save(Car car){return carRepository.save(car);}
}
