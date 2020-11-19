package eu.epitech.cashmanager.core.usecases.authenticate;

public class AuthenticationRequestModel {
    public String email;
    public String password;

    public AuthenticationRequestModel(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
