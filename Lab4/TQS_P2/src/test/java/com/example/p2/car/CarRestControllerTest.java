package com.example.p2.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarRestController.class)
class CarRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarService service;

    @Test
    public void whenPostCar_CreateCar() throws Exception{
        Car car1= new Car("BMW","M3");
        when(service.save(Mockito.any())).thenReturn(car1);

        mvc.perform(post("/api/cars").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(car1)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.maker", is("BMW")))
                .andExpect(jsonPath("$.model",is("M3")));

        verify(service,times(1)).save(Mockito.any());
    }

    @Test
    public void ifCars_GetCars_impliesReturnCarsJsonArray() throws Exception {
        Car car1= new Car("BMW","M3");
        Car car2 = new Car("Audi","A8");
        Car car3= new Car("Mercedes","Benz");

        List<Car> allCars = Arrays.asList(car1, car2, car3);
        given(service.getAllCars()).willReturn(allCars);

        mvc.perform(get("/api/cars").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].maker", is(car1.getMaker())))
                .andExpect(jsonPath("$[1].maker", is(car2.getMaker())))
                .andExpect(jsonPath("$[2].maker", is(car3.getMaker())));

        verify(service, VerificationModeFactory.times(1)).getAllCars();
    }
}