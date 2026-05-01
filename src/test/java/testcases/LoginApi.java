package testcases;

import base.AuthService;
import io.restassured.response.Response;
import model.request.LoginRequest;
import model.response.LoginResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginApi {

    @Test(description = "verify login api test ..!")
    public void verifyLoginApi() {
        AuthService authService = new AuthService();
        LoginRequest loginRequest = new LoginRequest("student@example.com", "secret123");
        Response response = authService.login(loginRequest);

        LoginResponse loginResponse = response.as(LoginResponse.class);

        System.out.println(response.asPrettyString());
        System.out.println(loginResponse.getToken());

        Assert.assertEquals(loginResponse.getUser().getEmail(), "student@example.com");
    }
}