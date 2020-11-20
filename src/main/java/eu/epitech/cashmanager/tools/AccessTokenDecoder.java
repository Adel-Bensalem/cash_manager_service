package eu.epitech.cashmanager.tools;

import eu.epitech.cashmanager.core.adapters.TokenDecoder;
import eu.epitech.cashmanager.core.data.Account;
import eu.epitech.cashmanager.core.exceptions.TokenDecodeFailureException;

public class AccessTokenDecoder implements TokenDecoder {
    @Override
    public Account decodeToken(String token) throws TokenDecodeFailureException {
        return new Account("test.test@test.test", "John Doe");
    }
}
