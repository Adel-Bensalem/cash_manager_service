package eu.epitech.cashmanager.core.usecases.retrievepaymentmethods;

import eu.epitech.cashmanager.core.adapters.Repository;
import eu.epitech.cashmanager.core.adapters.TokenDecoder;
import eu.epitech.cashmanager.core.data.Account;
import eu.epitech.cashmanager.core.data.PaymentMethod;
import eu.epitech.cashmanager.core.exceptions.AccountNotFoundException;
import eu.epitech.cashmanager.core.exceptions.TokenDecodeFailureException;

import java.util.ArrayList;
import java.util.List;

public class PaymentMethodsRetrievalInteractor {
    private Repository repository;
    private TokenDecoder tokenDecoder;

    public PaymentMethodsRetrievalInteractor(Repository repository, TokenDecoder tokenDecoder) {
        this.repository = repository;
        this.tokenDecoder = tokenDecoder;
    }

    public PaymentMethodsRetrievalResponseModel execute(PaymentMethodsRetrievalRequestModel requestModel) {
        try {
            Account decodedToken = tokenDecoder.decodeToken(requestModel.token);
            Account retrievedToken = repository.getAccountByEmail(decodedToken.email);
            List<PaymentMethod> paymentMethod = repository.getPaymentMethods();

            return new PaymentMethodsRetrievalResponseModel(paymentMethod);
        } catch (Exception e) {
            return new PaymentMethodsRetrievalResponseModel(
                    new ArrayList<>(),
                    e instanceof AccountNotFoundException,
                    e instanceof TokenDecodeFailureException,
                    !(e instanceof AccountNotFoundException) && !(e instanceof TokenDecodeFailureException)
            );
        }
    }
}
