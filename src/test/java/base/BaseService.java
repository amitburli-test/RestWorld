package base;

import filters.LoggingFilters;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class BaseService {
    private static final String BASE_URI = "https://api.eventhub.rahulshettyacademy.com";
    private RequestSpecification requestSpecification;

    static {
        RestAssured.filters(new LoggingFilters());
    }

    BaseService() {
        requestSpecification = given().baseUri(BASE_URI);
    }

    public Response postRequest(Object body, String endpoint) {
        Response response = requestSpecification.contentType(ContentType.JSON).body(body).when().post(endpoint);
        return response;
    }

    public Response getRequest(String endpoint) {
        Response response = requestSpecification.when().get(endpoint);
        return response;
    }

    public void setAuthToken(String token) {
        requestSpecification.header("Authorization", "Bearer " + token);
    }
}