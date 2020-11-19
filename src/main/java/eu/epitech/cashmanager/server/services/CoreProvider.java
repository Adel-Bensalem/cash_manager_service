package eu.epitech.cashmanager.server.services;

import eu.epitech.cashmanager.core.Core;
import eu.epitech.cashmanager.core.CoreFacade;
import eu.epitech.cashmanager.tools.AccessTokenGenerator;
import eu.epitech.cashmanager.tools.Database;
import org.springframework.stereotype.Service;

@Service
public class CoreProvider {
    public Core getCore() {
        return new CoreFacade(new Database(), new AccessTokenGenerator());
    }
}
