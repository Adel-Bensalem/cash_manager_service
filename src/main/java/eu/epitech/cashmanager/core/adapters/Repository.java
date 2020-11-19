package eu.epitech.cashmanager.core.adapters;

import eu.epitech.cashmanager.core.data.Account;

public interface Repository {
    Account getAccount() throws Exception;
}
