package base;

import io.restassured.response.Response;

public class AuthService extends BaseService {
    private final static String BASE_PATH="/api/auth/";

    public Response login(Object payload){
        return postRequest(payload, BASE_PATH+"login");
    }

    public Response register(Object payload){
        return postRequest(payload, BASE_PATH+"register");
    }

    public Response fetch(String token){
        setAuthToken(token);
        return getRequest(BASE_PATH+"me");
    }
}