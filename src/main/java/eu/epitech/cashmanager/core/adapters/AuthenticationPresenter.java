package eu.epitech.cashmanager.core.adapters;

import eu.epitech.cashmanager.core.usecases.authenticate.AuthenticationResponseModel;

public interface AuthenticationPresenter {
    void presentAuthenticationSuccess(AuthenticationResponseModel response);
    void presentAuthenticationFailure(AuthenticationResponseModel response);
}
