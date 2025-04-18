package jczech.pwr.ism.ism_lab02.controllers;

import jczech.pwr.ism.api.AuthorizationApi;
import jczech.pwr.ism.ism_lab02.services.AuthorizationService;
import jczech.pwr.ism.model.LoginDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationController implements AuthorizationApi {

    @Autowired
    private AuthorizationService authorizationService;

    @Override
    public ResponseEntity<Long> login(LoginDataDTO loginDataDTO) {
        var response = authorizationService.GetUserByEmail(loginDataDTO.getEmailAddress(), loginDataDTO.getPassword(), loginDataDTO.getRole().toString());

        if (response == 0L)
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(response);
    }


}
