package model.request;

public class RegisterRequest {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RegisterRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static class builder {
        private String email;
        private String password;

        public builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public RegisterRequest build(){
            RegisterRequest registerRequest = new RegisterRequest(email, password);
            return registerRequest;
        }
    }
}