package eu.epitech.cashmanager.tools;

import eu.epitech.cashmanager.core.adapters.Repository;
import eu.epitech.cashmanager.core.data.Account;

public class Database implements Repository {
    @Override
    public Account getAccount(String email, String password) throws Exception {
        return new Account(email, "John Doe");
    }
}
