package eu.epitech.cashmanager.server.controllers;

import eu.epitech.cashmanager.core.Core;
import eu.epitech.cashmanager.core.usecases.authenticate.AuthenticationRequestModel;
import eu.epitech.cashmanager.core.usecases.authenticate.AuthenticationResponseModel;
import eu.epitech.cashmanager.server.services.CoreProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {
    private CoreProvider coreProvider;

    public AuthenticationController(CoreProvider coreProvider) {
        this.coreProvider = coreProvider;
    }

    @ResponseBody
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity authenticate(@RequestBody AuthenticationRequestModel request) {
        Core core = coreProvider.getCore();
        AuthenticationResponseModel response = core.authenticate(request);

        return response.tokenGenerationFailed ?
                new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR) :
                response.accountNotFound ?
                        new ResponseEntity(HttpStatus.NOT_FOUND) :
                        new ResponseEntity("{ \"token\": \"" + response.token + "\" }", HttpStatus.OK);
    }
}
