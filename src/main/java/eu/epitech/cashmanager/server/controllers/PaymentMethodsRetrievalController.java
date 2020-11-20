package eu.epitech.cashmanager.server.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.epitech.cashmanager.core.Core;
import eu.epitech.cashmanager.core.usecases.retrievepaymentmethods.PaymentMethodsRetrievalRequestModel;
import eu.epitech.cashmanager.core.usecases.retrievepaymentmethods.PaymentMethodsRetrievalResponseModel;
import eu.epitech.cashmanager.server.services.CoreProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentMethodsRetrievalController {
    private CoreProvider coreProvider;

    public PaymentMethodsRetrievalController(CoreProvider coreProvider) {
        this.coreProvider = coreProvider;
    }

    @RequestMapping(path = "/payment-methods", method = RequestMethod.GET)
    public ResponseEntity retrievePaymentMethods(@RequestHeader("Authorization") String accessToken) {
        try {
            Core core = coreProvider.getCore();

            PaymentMethodsRetrievalResponseModel response = core.retrievePaymentMethods(new PaymentMethodsRetrievalRequestModel(
                    accessToken.substring("Bearer ".length())
            ));

            return response.tokenDecodeFailed || response.unExpectedError ?
                    new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR) :
                    response.accountNotFound ?
                            new ResponseEntity(HttpStatus.NOT_FOUND) :
                            new ResponseEntity(new ObjectMapper().writeValueAsString(response), HttpStatus.OK);
        } catch (JsonProcessingException e) {
            e.printStackTrace();

            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
