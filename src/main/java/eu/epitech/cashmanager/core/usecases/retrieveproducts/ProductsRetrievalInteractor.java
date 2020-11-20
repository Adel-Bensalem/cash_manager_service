package eu.epitech.cashmanager.core.usecases.retrieveproducts;

import eu.epitech.cashmanager.core.adapters.Repository;
import eu.epitech.cashmanager.core.adapters.TokenDecoder;
import eu.epitech.cashmanager.core.data.Account;
import eu.epitech.cashmanager.core.data.Product;
import eu.epitech.cashmanager.core.exceptions.AccountNotFoundException;
import eu.epitech.cashmanager.core.exceptions.TokenDecodeFailureException;

import java.util.ArrayList;
import java.util.List;

public class ProductsRetrievalInteractor {
    private Repository repository;
    private TokenDecoder tokenDecoder;

    public ProductsRetrievalInteractor(Repository repository, TokenDecoder tokenDecoder) {
        this.repository = repository;
        this.tokenDecoder = tokenDecoder;
    }

    public ProductsRetrievalResponseModel execute(ProductsRetrievalRequestModel requestModel) {
        try {
            Account decodedToken = tokenDecoder.decodeToken(requestModel.token);
            Account retrievedToken = repository.getAccountByEmail(decodedToken.email);
            List<Product> products = repository.getProducts();

            return new ProductsRetrievalResponseModel(products);
        } catch (Exception e) {
            return new ProductsRetrievalResponseModel(
                    new ArrayList<>(),
                    e instanceof AccountNotFoundException,
                    e instanceof TokenDecodeFailureException,
                    !(e instanceof AccountNotFoundException) && !(e instanceof TokenDecodeFailureException)
            );
        }
    }
}
