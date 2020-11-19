package eu.epitech.cashmanager.core;

import eu.epitech.cashmanager.core.adapters.Repository;
import eu.epitech.cashmanager.core.adapters.TokenGenerator;
import eu.epitech.cashmanager.core.usecases.authenticate.AuthenticationInteractor;
import eu.epitech.cashmanager.core.usecases.authenticate.AuthenticationRequestModel;
import eu.epitech.cashmanager.core.usecases.authenticate.AuthenticationResponseModel;

public class CoreFacade implements Core {
    Repository repository;
    TokenGenerator tokenGenerator;

    public CoreFacade(Repository repository, TokenGenerator tokenGenerator) {
        this.repository = repository;
        this.tokenGenerator = tokenGenerator;
    }

    public AuthenticationResponseModel authenticate(AuthenticationRequestModel requestModel) {
        return new AuthenticationInteractor(repository, tokenGenerator).execute(requestModel);
    }
}
