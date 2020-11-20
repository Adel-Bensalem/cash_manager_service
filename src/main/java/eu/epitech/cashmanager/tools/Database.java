package eu.epitech.cashmanager.tools;

import eu.epitech.cashmanager.core.adapters.Repository;
import eu.epitech.cashmanager.core.data.Account;
import eu.epitech.cashmanager.core.data.Product;
import eu.epitech.cashmanager.core.exceptions.AccountNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Database implements Repository {
    @Override
    public Account getAccount(String email, String password) throws AccountNotFoundException {
        return new Account(email, "John Doe");
    }

    @Override
    public Account getAccountByEmail(String email) throws AccountNotFoundException {
        return new Account(email, "John Doe");
    }

    @Override
    public List<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product("s1dQsd245q4s5d64qs6d456", "Product 1", 3.99F, "https://picsum.photos/100"));
        products.add(new Product("qsd5324sd564sq56d4qs6d5", "Product 2", 42F, "https://picsum.photos/100"));
        products.add(new Product("w45465c4q56s4d5q4e5r3z1", "Product 3", .50F, "https://picsum.photos/100"));
        products.add(new Product("qse5ea7334ez54arf21efs5", "Product 4", 399F, "https://picsum.photos/100"));
        products.add(new Product("yi78y6u7$i45u342yt12u01", "Product 5", 69F, "https://picsum.photos/100"));

        return products;
    }
}
