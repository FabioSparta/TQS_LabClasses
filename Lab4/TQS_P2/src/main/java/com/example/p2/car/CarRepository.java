package com.example.p2.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CarRepository extends JpaRepository<Car, Long> {
    public List<Car> findAll();
    public Car findByMakerAndModel(String maker,String model);
}
