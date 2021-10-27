package io.codification;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class bestBuyTest2 {

    String currentWorkingDirectory;

    @BeforeClass
    public void Setup(){

        baseURI = "http://localhost";

        port = 3030;

        basePath = "/products";
 
        currentWorkingDirectory = System.getProperty("user.dir");
    }

    @Test
    public void getProductApi(){

        given()
        .get()
        .then().log().all()
        .statusCode(200)
        .statusLine("HTTP/1.1 200 OK");

    }

    @Test
    public void getProductApiWithQueryParameters(){



        given()
        .queryParam("$limit", 2)
        .queryParam("$skip", 1)
        .get()
        .then().log().all()
        .statusCode(200)
        .statusLine("HTTP/1.1 200 OK");

    }

    @Test
    public void getProductApiWithQueryParametersAsMap(){

        Map<String, Object> params = new HashMap<String, Object>();

        // Prepare the query paramter as a map
        params.put("$limit", 2);
        params.put("$skip", 1);

        given()
        .queryParams(params)
        .get()
        .then().log().all()
        .body("limit", equalTo(2))
        .body("skip", equalTo(1))
        .statusCode(200)
        .statusLine("HTTP/1.1 200 OK");

    }

    @Test
    public void getProductApiWithPathParams(){


        given()
        .pathParam("id", 43900)
        .when()
        .get("/{id}")
        .then().log().all()
        .statusCode(200)
        .body("name", equalTo("Duracell - AAA Batteries (4-Pack)"))
        .statusLine("HTTP/1.1 200 OK");

    }

    @Test
    public void addProductWhenRequestPayloadIsString(){

        String requestPayload = "{\r\n  \"name\": \"Samsung Mobile\",\r\n  \"type\": \"Mobile\",\r\n  \"price\": 1000,\r\n  \"shipping\": 30,\r\n  \"upc\": \"string\",\r\n  \"description\": \"Best Mobile in the town\",\r\n  \"manufacturer\": \"Samsung\",\r\n  \"model\": \"string\",\r\n  \"url\": \"string\",\r\n  \"image\": \"string\"\r\n}";

        given().contentType(ContentType.JSON).body(requestPayload)
        .when().post().then().log().all().statusCode(201);
    }

    @Test
    public void addProductWhenRequestPayloadIsInJsonFile(){

        File requestPayload = new File(currentWorkingDirectory + "/testData/product.json");

        given().contentType(ContentType.JSON).body(requestPayload)
        .when().post().then().log().all().statusCode(201);
    }

    @Test
    public void addProductWhenRequestPayloadAsMap(){

        Map<String, Object> requestPayload = new HashMap<>();

        requestPayload.put("name", "Samsung Mobile");
		requestPayload.put("type", "Mobile");
		requestPayload.put("upc", "04133824019");
		requestPayload.put("price", 500);
		requestPayload.put("shipping", 40);
		requestPayload.put("description", "Samsung best Mobile");
		requestPayload.put("manufacturer", "Samsung");
		requestPayload.put("model", "M21");

        given().contentType(ContentType.JSON).body(requestPayload)
        .when().post().then().log().all().statusCode(201);
    }
}
