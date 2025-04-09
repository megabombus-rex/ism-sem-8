package jczech.pwr.ism.ism_lab02.controllers;

import jczech.pwr.ism.api.AuthorizationApi;
import jczech.pwr.ism.model.LoginDataDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationController implements AuthorizationApi {

    @Override
    public ResponseEntity<String> _login(LoginDataDTO loginDataDTO) {
        return AuthorizationApi.super._login(loginDataDTO);
    }

    @Override
    public ResponseEntity<String> login(LoginDataDTO loginDataDTO) {
        return AuthorizationApi.super.login(loginDataDTO);
    }
}
