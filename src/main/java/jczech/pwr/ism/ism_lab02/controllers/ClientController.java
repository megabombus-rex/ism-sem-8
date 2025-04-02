package jczech.pwr.ism.ism_lab02.controllers;

import jczech.pwr.ism.api.ClientApi;
import jczech.pwr.ism.model.CreateClientDTO;
import jczech.pwr.ism.model.GetAllClients200ResponseInner;
import jczech.pwr.ism.model.GetClientDTO;
import jczech.pwr.ism.model.UpdateClientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ClientController implements ClientApi {
    @Override
    public Optional<NativeWebRequest> getRequest() {
        return ClientApi.super.getRequest();
    }

    @Override
    public ResponseEntity<UUID> _createClient(CreateClientDTO createClientDTO) {
        return ClientApi.super._createClient(createClientDTO);
    }

    @Override
    public ResponseEntity<UUID> createClient(CreateClientDTO createClientDTO) {
        return ClientApi.super.createClient(createClientDTO);
    }

    @Override
    public ResponseEntity<List<GetAllClients200ResponseInner>> _getAllAdmins(Integer page, Integer count) {
        return ClientApi.super._getAllAdmins(page, count);
    }

    @Override
    public ResponseEntity<List<GetAllClients200ResponseInner>> getAllAdmins(Integer page, Integer count) {
        return ClientApi.super.getAllAdmins(page, count);
    }

    @Override
    public ResponseEntity<List<GetAllClients200ResponseInner>> _getAllClients(Integer page, Integer count) {
        return ClientApi.super._getAllClients(page, count);
    }

    @Override
    public ResponseEntity<List<GetAllClients200ResponseInner>> getAllClients(Integer page, Integer count) {
        return ClientApi.super.getAllClients(page, count);
    }

    @Override
    public ResponseEntity<GetClientDTO> _getClientAccount(UUID clientId) {
        return ClientApi.super._getClientAccount(clientId);
    }

    @Override
    public ResponseEntity<GetClientDTO> getClientAccount(UUID clientId) {
        return ClientApi.super.getClientAccount(clientId);
    }

    @Override
    public ResponseEntity<GetClientDTO> _getClientById(UUID clientId) {
        return ClientApi.super._getClientById(clientId);
    }

    @Override
    public ResponseEntity<GetClientDTO> getClientById(UUID clientId) {
        return ClientApi.super.getClientById(clientId);
    }

    @Override
    public ResponseEntity<UUID> _signUpC() {
        return ClientApi.super._signUpC();
    }

    @Override
    public ResponseEntity<UUID> signUpC() {
        return ClientApi.super.signUpC();
    }

    @Override
    public ResponseEntity<Void> _updateClientById(UUID clientId, UpdateClientDTO updateClientDTO) {
        return ClientApi.super._updateClientById(clientId, updateClientDTO);
    }

    @Override
    public ResponseEntity<Void> updateClientById(UUID clientId, UpdateClientDTO updateClientDTO) {
        return ClientApi.super.updateClientById(clientId, updateClientDTO);
    }
}
