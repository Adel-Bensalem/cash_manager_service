package eu.epitech.cashmanager.core.usecases.retrieveproducts;

import eu.epitech.cashmanager.core.data.Product;

import java.util.List;

public class ProductsRetrievalResponseModel {
    public List<Product> products;
    public Boolean accountNotFound;
    public Boolean tokenDecodeFailed;
    public Boolean unExpectedError;

    public ProductsRetrievalResponseModel(List<Product> products) {
        this.products = products;
        this.accountNotFound = false;
        this.tokenDecodeFailed = false;
        this.unExpectedError = false;
    }

    public ProductsRetrievalResponseModel(List<Product> products, Boolean accountNotFound, Boolean tokenDecodeFailed, Boolean unExpectedError) {
        this.products = products;
        this.accountNotFound = accountNotFound;
        this.tokenDecodeFailed = tokenDecodeFailed;
        this.unExpectedError = unExpectedError;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Boolean getAccountNotFound() {
        return accountNotFound;
    }

    public Boolean getTokenDecodeFailed() {
        return tokenDecodeFailed;
    }

    public Boolean getUnExpectedError() {
        return unExpectedError;
    }
}
