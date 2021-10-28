package specs;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {

    public static RequestSpecification postRequestSpecification(String endpoint){

     return   with().contentType(ContentType.JSON).basePath(endpoint).log().all();

    }

    public static RequestSpecification getAndDeleteRequestSpecification(String endpoint){
        return with().basePath(endpoint).log().all();
    }

    public static ResponseSpecification getSuccessResponseSpecification(){
        return expect().log().all().statusCode(200).statusLine("HTTP/1.1 200 OK");
    }

    public static ResponseSpecification getNotFoundResponseSpecification(){
        return expect().log().all().statusCode(404);
    }

    public static ResponseSpecification postSuccessResponseSpecification(){
        return expect().log().all().statusCode(201).statusLine("HTTP/1.1 201 Created");
    }
    
}
