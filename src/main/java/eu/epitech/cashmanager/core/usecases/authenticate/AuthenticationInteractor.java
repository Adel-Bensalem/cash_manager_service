package eu.epitech.cashmanager.core.usecases.authenticate;

import eu.epitech.cashmanager.core.adapters.Repository;
import eu.epitech.cashmanager.core.adapters.TokenGenerator;
import eu.epitech.cashmanager.core.data.Account;
import eu.epitech.cashmanager.core.exceptions.AccountNotFoundException;
import eu.epitech.cashmanager.core.exceptions.TokenGenerationFailureException;

public class AuthenticationInteractor {
    private Repository repository;
    private TokenGenerator tokenGenerator;

    public AuthenticationInteractor(Repository repository, TokenGenerator tokenGenerator) {
        this.repository = repository;
        this.tokenGenerator = tokenGenerator;
    }

    public AuthenticationResponseModel execute(AuthenticationRequestModel requestModel) {
        try {
            Account account = repository.getAccount(requestModel.email, requestModel.password);
            String token = tokenGenerator.generateToken(account);

            return new AuthenticationResponseModel(token, false, false);
        } catch (Exception e) {
            return new AuthenticationResponseModel(
                    "",
                    e instanceof AccountNotFoundException,
                    e instanceof TokenGenerationFailureException
            );
        }
    }
}
