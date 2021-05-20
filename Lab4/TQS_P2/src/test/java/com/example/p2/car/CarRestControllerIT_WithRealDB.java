package com.example.p2.car;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource( locations = "/application-integrationtest.properties")
public class CarRestControllerIT_WithRealDB {

    @LocalServerPort
    int randomServerPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CarRepository carRep;

    @AfterEach
    public void resetDB() {
        carRep.deleteAll();
    }

    @Test
    public void whenValidInput_thenCreateCar() {
        Car car1= new Car("BMW","M3");
        ResponseEntity<Car> posted = restTemplate.postForEntity("/api/cars", car1, Car.class);

        List<Car> found = carRep.findAll();
        assertThat(found).extracting(Car::getMaker,Car::getModel).containsOnly(tuple("BMW","M3"));
    }


    @Test
    public void givenCars_whenGetAllCars_thenReturnCars()  {
        Car car1= new Car("BMW","M3");
        Car car2 = new Car("Audi","A8");
        Car car3= new Car("Mercedes","Benz");

        carRep.save(car1);
        carRep.save(car2);
        carRep.save(car3);

        ResponseEntity<List<Car>> response = restTemplate
                .exchange("/api/cars", HttpMethod.GET, null, new ParameterizedTypeReference<>() {});

        assertThat(response.getBody()).hasSize(3).extracting(Car::getMaker,Car::getModel)
                .containsOnly(tuple("BMW","M3"),tuple("Audi","A8"),tuple("Mercedes","Benz"));

    }

    @Test
    public void whenValidMakerAndName_thenReturnCar() throws Exception {
        Car c1 = new Car("fiat", "500");
        ResponseEntity<Car> posted = restTemplate.postForEntity("/api/cars", c1, Car.class);

        ResponseEntity<Car> response = restTemplate
                .exchange("/api/car/fiat/500", HttpMethod.GET, null, new ParameterizedTypeReference<>() {});

        assertThat(response.getBody()).extracting(Car::getMaker,Car::getModel)
                .containsOnly("fiat","500");

    }
}
