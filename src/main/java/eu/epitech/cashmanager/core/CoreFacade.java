package eu.epitech.cashmanager.core;

import eu.epitech.cashmanager.core.adapters.Repository;
import eu.epitech.cashmanager.core.adapters.TokenDecoder;
import eu.epitech.cashmanager.core.adapters.TokenGenerator;
import eu.epitech.cashmanager.core.usecases.authenticate.AuthenticationInteractor;
import eu.epitech.cashmanager.core.usecases.authenticate.AuthenticationRequestModel;
import eu.epitech.cashmanager.core.usecases.authenticate.AuthenticationResponseModel;
import eu.epitech.cashmanager.core.usecases.retrievepaymentmethods.PaymentMethodsRetrievalInteractor;
import eu.epitech.cashmanager.core.usecases.retrievepaymentmethods.PaymentMethodsRetrievalRequestModel;
import eu.epitech.cashmanager.core.usecases.retrievepaymentmethods.PaymentMethodsRetrievalResponseModel;
import eu.epitech.cashmanager.core.usecases.retrieveproducts.ProductsRetrievalInteractor;
import eu.epitech.cashmanager.core.usecases.retrieveproducts.ProductsRetrievalRequestModel;
import eu.epitech.cashmanager.core.usecases.retrieveproducts.ProductsRetrievalResponseModel;

public class CoreFacade implements Core {
    Repository repository;
    TokenGenerator tokenGenerator;
    TokenDecoder tokenDecoder;

    public CoreFacade(Repository repository, TokenGenerator tokenGenerator, TokenDecoder tokenDecoder) {
        this.repository = repository;
        this.tokenGenerator = tokenGenerator;
        this.tokenDecoder = tokenDecoder;
    }

    public AuthenticationResponseModel authenticate(AuthenticationRequestModel requestModel) {
        return new AuthenticationInteractor(repository, tokenGenerator).execute(requestModel);
    }

    public ProductsRetrievalResponseModel retrieveProducts(ProductsRetrievalRequestModel requestModel) {
        return new ProductsRetrievalInteractor(repository, tokenDecoder).execute(requestModel);
    }

    public PaymentMethodsRetrievalResponseModel retrievePaymentMethods(PaymentMethodsRetrievalRequestModel requestModel) {
        return new PaymentMethodsRetrievalInteractor(repository, tokenDecoder).execute(requestModel);
    }
}
