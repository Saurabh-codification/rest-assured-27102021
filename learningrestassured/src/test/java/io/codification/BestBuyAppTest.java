package io.codification;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class BestBuyAppTest {

    @Test
    public void getProductApi(){

        //Create the request
        RequestSpecification request = RestAssured.given();

        request.baseUri("http://localhost:3030");

        request.basePath("/products");

        //Perform an action to send the request
        Response response = request.when().get();

        response.prettyPrint();


        //Add assertions or post procee
        ValidatableResponse valResponse = response.then();
        
        valResponse.statusCode(200);

        valResponse.statusLine("HTTP/1.1 200 OK");
       
    }
    
}
