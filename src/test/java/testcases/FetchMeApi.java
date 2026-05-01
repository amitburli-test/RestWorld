package testcases;

import base.AuthService;
import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.request.RegisterRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.core.IsEqual.equalTo;

public class FetchMeApi {

    @Test(groups = "sanity")
    public void verifyFetchMeApi() {
        Faker faker = new Faker();
        String pwd = faker.internet().password();
        String email = faker.internet().emailAddress();

        RegisterRequest registerRequest = new RegisterRequest.builder()
                .setPassword(pwd)
                .setEmail(email)
                .build();

        AuthService authService = new AuthService();
        Response response = authService.register(registerRequest);

        JsonPath js = new JsonPath(response.asString());
        String token = js.get("token");

        response = authService.fetch(token);
        response.asPrettyString();

        response.then().body("success", equalTo(true)).log().all();

        boolean success = response.jsonPath().get("success");
        Assert.assertTrue(success);
    }
}