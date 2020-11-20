package eu.epitech.cashmanager.core.adapters;

import eu.epitech.cashmanager.core.data.Account;
import eu.epitech.cashmanager.core.exceptions.TokenDecodeFailureException;

public interface TokenDecoder {
    Account decodeToken(String token) throws TokenDecodeFailureException;
}
