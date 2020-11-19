package eu.epitech.cashmanager.core.usecases.authenticate;

import eu.epitech.cashmanager.core.adapters.TokenGenerator;
import eu.epitech.cashmanager.core.data.Account;
import eu.epitech.cashmanager.core.exceptions.AccountNotFoundException;
import eu.epitech.cashmanager.core.exceptions.TokenGenerationFailureException;
import eu.epitech.cashmanager.core.usecases.Interactor;
import eu.epitech.cashmanager.core.adapters.AuthenticationPresenter;
import eu.epitech.cashmanager.core.adapters.Repository;

public class AuthenticationInteractor implements Interactor<AuthenticationRequestModel> {
    private Repository repository;
    private AuthenticationPresenter presenter;
    private TokenGenerator tokenGenerator;

    public AuthenticationInteractor(Repository repository, AuthenticationPresenter presenter, TokenGenerator tokenGenerator) {
        this.repository = repository;
        this.presenter = presenter;
        this.tokenGenerator = tokenGenerator;
    }

    public void execute(AuthenticationRequestModel authenticationRequestModel) {
        try {
            Account account = repository.getAccount();
            String token = tokenGenerator.generateToken(account);

            presenter.presentAuthenticationSuccess(new AuthenticationResponseModel(token, false, false));
        } catch (Exception e) {
            presenter.presentAuthenticationFailure(new AuthenticationResponseModel(
                    "",
                    e instanceof AccountNotFoundException,
                    e instanceof TokenGenerationFailureException
            ));
        }
    }
}
