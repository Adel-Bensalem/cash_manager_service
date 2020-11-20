package eu.epitech.cashmanager.core.adapters;

import eu.epitech.cashmanager.core.data.Account;
import eu.epitech.cashmanager.core.exceptions.TokenGenerationFailureException;

public interface TokenGenerator {
    String generateToken(Account data) throws TokenGenerationFailureException;
}
