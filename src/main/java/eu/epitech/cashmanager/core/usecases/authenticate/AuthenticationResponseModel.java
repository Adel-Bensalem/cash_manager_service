package eu.epitech.cashmanager.core.usecases.authenticate;

public class AuthenticationResponseModel {
    public String token;
    public Boolean accountNotFound;
    public Boolean tokenGenerationFailed;

    public AuthenticationResponseModel(String token, Boolean accountNotFound, Boolean tokenGenerationFailed) {
        this.token = token;
        this.accountNotFound = accountNotFound;
        this.tokenGenerationFailed = tokenGenerationFailed;
    }
}
