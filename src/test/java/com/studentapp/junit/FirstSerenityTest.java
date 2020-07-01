package com.studentapp.junit;

import io.restassured.RestAssured;
import net.serenitybdd.core.exceptions.TestCompromisedException;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class FirstSerenityTest {

    @BeforeClass
    public static void setup(){
        RestAssured.baseURI = "http://localhost:8085/student";
    }

    @Test
    public void getAllStudents(){
        System.out.println("Test ok");
        SerenityRest.given()
                .when()
                .get("/list")
                .then()
                .statusCode(200);
    }

    @Test
    public void thisIsAFailingTest(){
        SerenityRest.given()
                .when()
                .get("/list")
                .then()
                .statusCode(500);
    }

    @Pending
    @Test
    public void thisIsAPedingTest(){
        System.out.println("Test Peding");
    }

    @Ignore
    @Test
    public void thisIsASkippedTest(){
        System.out.println("Test Ignore");
    }

    @Test
    public void thisIsTestWithError(){
        System.out.println("This is an error" + (5/0));
    }

    @Test
    public void thisIsTestCompromised(){
        throw new TestCompromisedException("Test Compromised");
    }

    @Manual
    @Test
    public void thisIsAManualTest(){
    }

}
