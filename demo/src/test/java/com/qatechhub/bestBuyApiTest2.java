package com.qatechhub;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class bestBuyApiTest2 {
 
    @BeforeClass
    public void setup(){
        baseURI = "http://localhost";
        port = 3030;
    }

    @Test
    public void sendGetRequest(){
        RestAssured.given().baseUri("http://localhost:3030")
        .get().then().statusCode(200).statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void sendGetRequest2(){
        given()
        .baseUri("http://localhost:3030")
        .when()
        .get("/products")
        .then().statusCode(200)
        .statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void verifyGetRequestWithQueryParams(){
        given()
        .queryParam("$limit", 5)
        .queryParam("$skip", 1)
        .when().get("/products")
        .then().log().all()
        .statusCode(200)
        .body("$limit", equalTo(5));

    }
}
