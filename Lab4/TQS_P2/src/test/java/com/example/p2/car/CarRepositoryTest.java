package com.example.p2.car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;


@DataJpaTest
class CarRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository carRep;

    @Test
    public void whenFindByMakerAndModel_thenReturnCar() {
        Car c1 = new Car("BMW", "M3");
        entityManager.persistAndFlush(c1);

        Car found = carRep.findByMakerAndModel("BMW","M3");

        assertThat(found.getMaker()).isEqualTo(c1.getMaker());
        assertThat(found.getModel()).isEqualTo(c1.getModel());
    }

    @Test
    public void whenFindByNonExistentMakerOrModel_thenReturnNull() {
        Car c5 = carRep.findByMakerAndModel("blablabla","blablabla");
        assertThat(c5).isNull();
    }

    @Test
    public void givenListOfCars_whenFindAll_thenReturnAllCars() {
        Car c2 = new Car("Audi", "A8");
        Car c3 = new Car("Ford", "Mustang");

        entityManager.persist(c2);
        entityManager.persist(c3);
        entityManager.flush();

        List<Car> cars = carRep.findAll();

        assertThat(cars).hasSize(2).extracting(Car::getMaker,Car::getModel)
                .containsOnly(tuple("Audi","A8"),tuple("Ford","Mustang"));
    }
}