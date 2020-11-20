package eu.epitech.cashmanager.core.usecases.retrievepaymentmethods;

import eu.epitech.cashmanager.core.data.PaymentMethod;

import java.util.List;

public class PaymentMethodsRetrievalResponseModel {
    public List<PaymentMethod> paymentMethods;
    public Boolean accountNotFound;
    public Boolean tokenDecodeFailed;
    public Boolean unExpectedError;

    public PaymentMethodsRetrievalResponseModel(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
        this.accountNotFound = false;
        this.tokenDecodeFailed = false;
        this.unExpectedError = false;
    }

    public PaymentMethodsRetrievalResponseModel(List<PaymentMethod> paymentMethods, Boolean accountNotFound, Boolean tokenDecodeFailed, Boolean unExpectedError) {
        this.paymentMethods = paymentMethods;
        this.accountNotFound = accountNotFound;
        this.tokenDecodeFailed = tokenDecodeFailed;
        this.unExpectedError = unExpectedError;
    }
}
