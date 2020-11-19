package eu.epitech.cashmanager.core;

import eu.epitech.cashmanager.core.adapters.Presenter;
import eu.epitech.cashmanager.core.adapters.Repository;
import eu.epitech.cashmanager.core.adapters.TokenGenerator;
import eu.epitech.cashmanager.core.usecases.authenticate.AuthenticationInteractor;
import eu.epitech.cashmanager.core.usecases.authenticate.AuthenticationRequestModel;

public class CoreFacade implements Core {
    Repository repository;
    Presenter presenter;
    TokenGenerator tokenGenerator;

    public CoreFacade(Repository repository, Presenter presenter, TokenGenerator tokenGenerator) {
        this.repository = repository;
        this.presenter = presenter;
        this.tokenGenerator = tokenGenerator;
    }

    public void authenticate(AuthenticationRequestModel requestModel) {
        new AuthenticationInteractor(repository, presenter, tokenGenerator);
    }
}
