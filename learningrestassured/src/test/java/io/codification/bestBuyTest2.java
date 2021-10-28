package io.codification;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import static bestBuyAppRoutes.Routes.*;
import io.codification.bestBuyApp.ProductPojo;
import static specs.Specifications.*;

import static restClient.RestClient.*;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.Status;

public class bestBuyTest2 extends BaseTest {

    @Test
    public void getProductApi() {

        reportUtils.createTestCase("Get Product API");

        SendGetRequest(PRODUCTS).then().spec(getSuccessResponseSpecification());

        reportUtils.addLog(Status.INFO, "Verify Get Product API");

    }

    @Test
    public void getProductApiWithQueryParameters() {

        reportUtils.createTestCase("Get Product API with Query Parameters");

        given().queryParam("$limit", 2).queryParam("$skip", 1).get().then().log().all().statusCode(200)
                .statusLine("HTTP/1.1 200 OK");

    }

    @Test
    public void getProductApiWithQueryParametersAsMap() {

        Map<String, Object> params = new HashMap<String, Object>();

        // Prepare the query paramter as a map
        params.put("$limit", 2);
        params.put("$skip", 1);

        SendGetRequest(PRODUCTS, params).then().log().all().body("limit", equalTo(2)).body("skip", equalTo(1))
                .statusCode(200).statusLine("HTTP/1.1 200 OK");

    }

    @Test
    public void getProductApiWithPathParams() {

        given().pathParam("id", 43900).when().get("/{id}").then().log().all().statusCode(200)
                .body("name", equalTo("Duracell - AAA Batteries (4-Pack)")).statusLine("HTTP/1.1 200 OK");

    }

    @Test
    public void addProductWhenRequestPayloadIsString() {

        String requestPayload = "{\r\n  \"name\": \"Samsung Mobile\",\r\n  \"type\": \"Mobile\",\r\n  \"price\": 1000,\r\n  \"shipping\": 30,\r\n  \"upc\": \"string\",\r\n  \"description\": \"Best Mobile in the town\",\r\n  \"manufacturer\": \"Samsung\",\r\n  \"model\": \"string\",\r\n  \"url\": \"string\",\r\n  \"image\": \"string\"\r\n}";

        SendPostRequest(PRODUCTS, requestPayload).then().spec(postSuccessResponseSpecification());
    }

    @Test
    public void addProductWhenRequestPayloadIsInJsonFile() {

        File requestPayload = new File(currentWorkingDirectory + "/testData/product.json");

        SendPostRequest(PRODUCTS, requestPayload).then().spec(postSuccessResponseSpecification());
    }

    @Test
    public void addProductWhenRequestPayloadAsMap() {

        Map<String, Object> requestPayload = new HashMap<>();

        requestPayload.put("name", "Samsung Mobile");
        requestPayload.put("type", "Mobile");
        requestPayload.put("upc", "04133824019");
        requestPayload.put("price", 500);
        requestPayload.put("shipping", 40);
        requestPayload.put("description", "Samsung best Mobile");
        requestPayload.put("manufacturer", "Samsung");
        requestPayload.put("model", "M21");

        SendPostRequest(PRODUCTS, requestPayload).then().spec(postSuccessResponseSpecification());
    }

    @Test
    public void addProductWhenRequestPayloadAsPojoObject() {

        ProductPojo requestPayload = new ProductPojo();

        requestPayload.setName("IPhone 13");
        requestPayload.setType("Mobile Phone");
        requestPayload.setPrice(300);
        requestPayload.setShipping(20);
        requestPayload.setUpc("dsfbsdf");
        requestPayload.setDescription("Best Iphone Ever");
        requestPayload.setManufacturer("Apple");
        requestPayload.setModel("Iphone 13");
        requestPayload.setUrl("kjsdfkjsdhlf");
        requestPayload.setImage("hdskjfhkj");

        SendPostRequest(PRODUCTS, requestPayload).then().spec(postSuccessResponseSpecification());
    }

    @Test
    public void EditProduct() {

        ProductPojo requestPayload = new ProductPojo();

        requestPayload.setName("IPhone 13");
        requestPayload.setType("Mobile Phone");
        requestPayload.setPrice(300);
        requestPayload.setShipping(20);
        requestPayload.setUpc("dsfbsdf");
        requestPayload.setDescription("Best Iphone Ever");
        requestPayload.setManufacturer("Apple");
        requestPayload.setModel("Iphone 13");
        requestPayload.setUrl("kjsdfkjsdhlf");
        requestPayload.setImage("hdskjfhkj");

        Integer id = SendPostRequest(PRODUCTS, requestPayload).then().extract().path("id");


        ProductPojo requestPayloadForUpdate = new ProductPojo();

        requestPayloadForUpdate.setName("IPhone 12");
        requestPayloadForUpdate.setType("Mobile Phone");
        requestPayloadForUpdate.setPrice(300);
        requestPayloadForUpdate.setShipping(20);
        requestPayloadForUpdate.setUpc("dsfbsdf");
        requestPayloadForUpdate.setDescription("Best Iphone Ever");
        requestPayloadForUpdate.setManufacturer("Apple");
        requestPayloadForUpdate.setModel("Iphone 12");
        requestPayloadForUpdate.setUrl("kjsdfkjsdhlf");
        requestPayloadForUpdate.setImage("hdskjfhkj");

        String endpointUrl = String.format("%s/%d", PRODUCTS, id);

        System.out.println(endpointUrl);

        SendPutRequest(endpointUrl, requestPayloadForUpdate).then().spec(getSuccessResponseSpecification());

        SendDeleteRequest(endpointUrl).then().spec(getSuccessResponseSpecification());

        SendGetRequest(endpointUrl).then().spec(getNotFoundResponseSpecification());
    }
}
