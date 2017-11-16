package com.example;

import static io.restassured.RestAssured.get;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


import com.example.Entity.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestAssuredTests {

    /*@org.junit.Test
    public void getUsers(){
        User[] users = given().relaxedHTTPSValidation()
                .when()
                .contentType("application/json")
                .get("http://localhost/users")
                .then().extract().body().as(User[].class);
        assertThat(users.length, greaterThan(4));
    }*/


    @org.junit.Test
    public void getUsers(){
        given().relaxedHTTPSValidation()
                .auth().basic("savva_gench", "19021992")
                .when()
                .get("http://localhost/greeting")
                .thenReturn().prettyPrint();
    }


}
