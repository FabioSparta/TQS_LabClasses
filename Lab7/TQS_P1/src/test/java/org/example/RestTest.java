package org.example;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;


import  io.restassured.RestAssured.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;


class RestTest {
    // testing https://jsonplaceholder.typicode.com/todos
    /*
    Exercise:
        - the endpoint to list all ToDo is available (status code 200)
        - the title of ToDo #4 is “et porro tempora”
        - When listing all “todos”, you get id #198 and #199 in the results.
     */

    @Test
    void whenListAll_thenStatusCode200(){
        RestAssured.when().get("https://jsonplaceholder.typicode.com/todos")
                .then()
                .statusCode(200);
    }

    @Test
    void whenGetSpecificTODO_thenCheckTitle(){
        String expected = "et porro tempora";
        RestAssured.when().get("https://jsonplaceholder.typicode.com/todos/4")
                .then()
                .statusCode(200)
                .and().body("title",equalTo(expected))
                .and().body("id",equalTo(4));
    }

    @Test
    void whenGetAll_thenCheck198_199(){
        RestAssured.when().get("https://jsonplaceholder.typicode.com/todos")
                .then()
                .statusCode(200)
                .body("id",hasItems(198,199));
    }
}