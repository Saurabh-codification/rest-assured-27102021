package restClient;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static specs.Specifications.*;

import java.util.Map;

public class RestClient {

    public static Response SendGetRequest(String endpoint) {
        
        return given(getAndDeleteRequestSpecification(endpoint)).when().get();

    }

    public static Response SendGetRequest(String endpoint, Map<String, Object> queryParam) {
        
        return given(getAndDeleteRequestSpecification(endpoint)).queryParams(queryParam).when().get();

    }
    
    public static Response SendPostRequest(String endpoint, Object requestPayload) {
        
        return given(postRequestSpecification(endpoint)).when().body(requestPayload).post();

    }


    public static Response SendPatchRequest(String endpoint, Object requestPayload) {
        
        return given(postRequestSpecification(endpoint)).when().body(requestPayload).patch();


    }

    public static Response SendPutRequest(String endpoint, Object requestPayload) {
        
        return given(postRequestSpecification(endpoint)).when().body(requestPayload).patch();


    }

    public static Response SendDeleteRequest(String endpoint) {
        
        return given(getAndDeleteRequestSpecification(endpoint)).when().delete();

    }
}
