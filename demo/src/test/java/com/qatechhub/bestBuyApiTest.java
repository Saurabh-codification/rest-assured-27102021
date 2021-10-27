package com.qatechhub;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class bestBuyApiTest {

    @Test
    public void getApiTest(){
        RequestSpecification request = RestAssured.given();

        request.baseUri("http://localhost:3030");

        request.basePath("/products");

        Response response = request.when().get();

        response.prettyPrint();
        
        String responseAsString = response.asString();

        System.out.println("Response : "+ responseAsString);

        ValidatableResponse valResponse = response.then();

        valResponse.statusCode(200);

        valResponse.statusLine("HTTP/1.1 200 OK");

    }
    
}
