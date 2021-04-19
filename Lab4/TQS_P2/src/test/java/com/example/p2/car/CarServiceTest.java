package com.example.p2.car;

import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @Mock( lenient = true)
    private CarRepository carRepository;

    @InjectMocks
    private CarService carService;

    @BeforeEach
    public void setUp() {
        Car car1= new Car("BMW","M3");
        Car car2 = new Car("Audi","A8");
        Car car3= new Car("Mercedes","Benz");

        List<Car> allCars = Arrays.asList(car1,car2,car3);

        Mockito.when(carRepository.findByMakerAndModel(car1.getMaker(),car1.getModel())).thenReturn(car1);
        Mockito.when(carRepository.findByMakerAndModel(car2.getMaker(),car2.getModel())).thenReturn(car2);
        Mockito.when(carRepository.findByMakerAndModel("wrong","wrong")).thenReturn(null);

        Mockito.when(carRepository.findById(car3.getCarId())).thenReturn(Optional.of(car3));
        Mockito.when(carRepository.findAll()).thenReturn(allCars);
        Mockito.when(carRepository.findById(-99L)).thenReturn(Optional.empty());
    }


    @Test
    public void ifValidMaker_Model_CarShouldBeFound() {
        Car found = carService.getCarByMakerAndModel("BMW","M3");
        assertThat(found.getMaker()).isEqualTo("BMW");
        assertThat(found.getModel()).isEqualTo("M3");
    }

    @Test
    public void ifNotValidMaker_Model_CarShouldNotBeFound() {
        Car car = carService.getCarByMakerAndModel("wrong","wrong");
        assertThat(car).isNull();
        Mockito.verify(carRepository, VerificationModeFactory.times(1)).findByMakerAndModel("wrong","wrong");
    }

    @Test
    public void ifNotValidId_CarShouldNotBeFound() {
        Car car = carService.getCarById(-99L);
        Mockito.verify(carRepository,VerificationModeFactory.times(1)).findById(-99L);
        assertThat(car).isNull();
    }

    @Test
    public void if3Cars_getAll_impliesReturn3Records() {
        List<Car> allCars = carService.getAllCars();
        Mockito.verify(carRepository,VerificationModeFactory.times(1)).findAll();
        assertThat(allCars).hasSize(3)
                .extracting(Car::getMaker,Car::getModel)
                .contains(tuple("BMW","M3"),tuple("Audi","A8"),tuple("Mercedes","Benz"));
    }
}