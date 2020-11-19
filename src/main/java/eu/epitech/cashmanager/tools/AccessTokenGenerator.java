package eu.epitech.cashmanager.tools;

import eu.epitech.cashmanager.core.adapters.TokenGenerator;
import eu.epitech.cashmanager.core.data.Account;


public class AccessTokenGenerator implements TokenGenerator {
    @Override
    public String generateToken(Account data) {
        return data.email;
    }
}
