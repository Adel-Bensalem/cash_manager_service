package eu.epitech.cashmanager.server.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.epitech.cashmanager.core.Core;
import eu.epitech.cashmanager.core.usecases.retrieveproducts.ProductsRetrievalRequestModel;
import eu.epitech.cashmanager.core.usecases.retrieveproducts.ProductsRetrievalResponseModel;
import eu.epitech.cashmanager.server.services.CoreProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductRetrievalController {
    private CoreProvider coreProvider;

    public ProductRetrievalController(CoreProvider coreProvider) {
        this.coreProvider = coreProvider;
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public ResponseEntity authenticate(@RequestHeader("Authorization") String accessToken) {
        try {
            Core core = coreProvider.getCore();

            ProductsRetrievalResponseModel response = core.retrieveProducts(new ProductsRetrievalRequestModel(
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
