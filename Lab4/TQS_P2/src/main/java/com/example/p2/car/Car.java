package com.example.p2.car;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Car {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carId;

    private String maker;
    private String model;

    //Constructors
    public Car() { }
    public Car(String maker, String model) {
        this.maker = maker;
        this.model = model;
    }

    //Getters & Setters
    public Long getCarId() { return carId; }
    public String getMaker() { return maker; }
    public String getModel() { return model; }

    public void setCarId(Long carId) { this.carId = carId; }
    public void setMaker(String maker) { this.maker = maker; }
    public void setModel(String model) { this.model = model; }

    // Hash & Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return carId.equals(car.carId) &&
                Objects.equals(maker, car.maker) &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, maker, model);
    }
}
