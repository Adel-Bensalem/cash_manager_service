package eu.epitech.cashmanager.core;

import eu.epitech.cashmanager.core.usecases.authenticate.AuthenticationRequestModel;
import eu.epitech.cashmanager.core.usecases.authenticate.AuthenticationResponseModel;

public interface Core {
    AuthenticationResponseModel authenticate(AuthenticationRequestModel requestModel);
}
