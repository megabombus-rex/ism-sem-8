package jczech.pwr.ism.ism_lab02.controllers;

import jczech.pwr.ism.api.AdminApi;
import jczech.pwr.ism.model.BusinessVerificationDTO;
import jczech.pwr.ism.model.CreateAdminDTO;
import jczech.pwr.ism.model.GetAdminDTO;
import jczech.pwr.ism.model.UpdateAdminDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import java.util.UUID;

@RestController
public class AdminController implements AdminApi {

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return AdminApi.super.getRequest();
    }

    @Override
    public ResponseEntity<UUID> _createAdmin(CreateAdminDTO createAdminDTO) {
        return AdminApi.super._createAdmin(createAdminDTO);
    }

    @Override
    public ResponseEntity<UUID> createAdmin(CreateAdminDTO createAdminDTO) {
        return AdminApi.super.createAdmin(createAdminDTO);
    }

    @Override
    public ResponseEntity<Void> _deleteUserById(UUID userId, String role) {
        return AdminApi.super._deleteUserById(userId, role);
    }

    @Override
    public ResponseEntity<Void> deleteUserById(UUID userId, String role) {
        return AdminApi.super.deleteUserById(userId, role);
    }

    @Override
    public ResponseEntity<GetAdminDTO> _getAdminById(UUID adminId) {
        return AdminApi.super._getAdminById(adminId);
    }

    @Override
    public ResponseEntity<GetAdminDTO> getAdminById(UUID adminId) {
        return AdminApi.super.getAdminById(adminId);
    }

    @Override
    public ResponseEntity<Void> _reinstateUserById(UUID userId, String role) {
        return AdminApi.super._reinstateUserById(userId, role);
    }

    @Override
    public ResponseEntity<Void> reinstateUserById(UUID userId, String role) {
        return AdminApi.super.reinstateUserById(userId, role);
    }

    @Override
    public ResponseEntity<UUID> _signUpA() {
        return AdminApi.super._signUpA();
    }

    @Override
    public ResponseEntity<UUID> signUpA() {
        return AdminApi.super.signUpA();
    }

    @Override
    public ResponseEntity<Void> _suspendUserById(UUID userId, String role) {
        return AdminApi.super._suspendUserById(userId, role);
    }

    @Override
    public ResponseEntity<Void> suspendUserById(UUID userId, String role) {
        return AdminApi.super.suspendUserById(userId, role);
    }

    @Override
    public ResponseEntity<Void> _updateAdminById(UUID adminId, UpdateAdminDTO updateAdminDTO) {
        return AdminApi.super._updateAdminById(adminId, updateAdminDTO);
    }

    @Override
    public ResponseEntity<Void> updateAdminById(UUID adminId, UpdateAdminDTO updateAdminDTO) {
        return AdminApi.super.updateAdminById(adminId, updateAdminDTO);
    }

    @Override
    public ResponseEntity<Void> _verifyBusinessById(UUID businessId, BusinessVerificationDTO businessVerificationDTO) {
        return AdminApi.super._verifyBusinessById(businessId, businessVerificationDTO);
    }

    @Override
    public ResponseEntity<Void> verifyBusinessById(UUID businessId, BusinessVerificationDTO businessVerificationDTO) {
        return AdminApi.super.verifyBusinessById(businessId, businessVerificationDTO);
    }
}
