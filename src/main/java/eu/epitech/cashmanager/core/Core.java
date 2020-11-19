package eu.epitech.cashmanager.core;

import eu.epitech.cashmanager.core.usecases.authenticate.AuthenticationRequestModel;

public interface Core {
    void authenticate(AuthenticationRequestModel requestModel);
}
