package testcases;

import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.request.RegisterRequest;
import org.testng.annotations.Test;
import base.AuthService;

public class RegisterApi {

    @Test
    public void verifyRegisterApi() {
        Faker faker = new Faker();
        String pwd = faker.internet().password();
        String email = faker.internet().emailAddress();

        RegisterRequest registerRequest = new RegisterRequest
                .builder()
                .setPassword(pwd)
                .setEmail(email).build();

        System.out.println("--------------------" + registerRequest);

        AuthService authService = new AuthService();
        Response response = authService.register(registerRequest);
        System.out.println(response.asPrettyString());

        JsonPath js = new JsonPath(response.asString());
        String token = js.get("token");
        System.out.println(token);
    }
}