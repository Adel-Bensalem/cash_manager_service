package eu.epitech.cashmanager.core.adapters;

import eu.epitech.cashmanager.core.data.Account;
import eu.epitech.cashmanager.core.data.PaymentMethod;
import eu.epitech.cashmanager.core.data.Product;
import eu.epitech.cashmanager.core.exceptions.AccountNotFoundException;

import java.util.List;

public interface Repository {
    Account getAccount(String email, String password) throws AccountNotFoundException;
    Account getAccountByEmail(String email) throws AccountNotFoundException;
    List<Product> getProducts();
    List<PaymentMethod> getPaymentMethods();
}
