package jczech.pwr.ism.ism_lab02.controllers;

import jczech.pwr.ism.api.ClientApi;
import jczech.pwr.ism.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ClientController implements ClientApi {
    @Override
    public ResponseEntity<Void> updateClientById(UUID clientId, UpdateClientDTO updateClientDTO) {
        return ClientApi.super.updateClientById(clientId, updateClientDTO);
    }

    @Override
    public ResponseEntity<UUID> signUpC(CreateClientDTO createClientDTO) {
        return ClientApi.super.signUpC(createClientDTO);
    }

    @Override
    public ResponseEntity<GetClientDTO> getClientById(UUID clientId) {
        return ClientApi.super.getClientById(clientId);
    }

    @Override
    public ResponseEntity<GetClientDTO> getClientAccount(String clientId) {
        return ClientApi.super.getClientAccount(clientId);
    }

    @Override
    public ResponseEntity<List<GetAllClients200ResponseInner>> getAllClients(Integer page, Integer count, String clientName) {
        return ClientApi.super.getAllClients(page, count, clientName);
    }

    @Override
    public ResponseEntity<List<GetAllAdmins200ResponseInner>> getAllAdmins(Integer page, Integer count, String adminName) {
        return ClientApi.super.getAllAdmins(page, count, adminName);
    }

    @Override
    public ResponseEntity<UUID> createClient(CreateClientDTO createClientDTO) {
        return ClientApi.super.createClient(createClientDTO);
    }

}
