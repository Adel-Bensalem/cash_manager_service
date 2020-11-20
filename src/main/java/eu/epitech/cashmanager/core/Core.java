package eu.epitech.cashmanager.core;

import eu.epitech.cashmanager.core.usecases.authenticate.AuthenticationRequestModel;
import eu.epitech.cashmanager.core.usecases.authenticate.AuthenticationResponseModel;
import eu.epitech.cashmanager.core.usecases.retrievepaymentmethods.PaymentMethodsRetrievalRequestModel;
import eu.epitech.cashmanager.core.usecases.retrievepaymentmethods.PaymentMethodsRetrievalResponseModel;
import eu.epitech.cashmanager.core.usecases.retrieveproducts.ProductsRetrievalRequestModel;
import eu.epitech.cashmanager.core.usecases.retrieveproducts.ProductsRetrievalResponseModel;

public interface Core {
    AuthenticationResponseModel authenticate(AuthenticationRequestModel requestModel);
    ProductsRetrievalResponseModel retrieveProducts(ProductsRetrievalRequestModel requestModel);
    PaymentMethodsRetrievalResponseModel retrievePaymentMethods(PaymentMethodsRetrievalRequestModel requestModel);
}
