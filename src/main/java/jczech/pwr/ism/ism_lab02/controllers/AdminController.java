package jczech.pwr.ism.ism_lab02.controllers;

import jczech.pwr.ism.api.AdminApi;
import jczech.pwr.ism.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import java.util.UUID;

@RestController
public class AdminController implements AdminApi {

    @Override
    public ResponseEntity<UUID> createAdmin(CreateAdminDTO createAdminDTO) {
        return AdminApi.super.createAdmin(createAdminDTO);
    }

    @Override
    public ResponseEntity<Void> deleteUserById(UUID userId, String role) {
        return AdminApi.super.deleteUserById(userId, role);
    }


    @Override
    public ResponseEntity<GetAdminDTO> getAdminById(UUID adminId) {
        return AdminApi.super.getAdminById(adminId);
    }

    @Override
    public ResponseEntity<GetVendorDTO> getVendorById(UUID vendorId) {
        return AdminApi.super.getVendorById(vendorId);
    }

    @Override
    public ResponseEntity<Void> reinstateUserById(UUID userId) {
        return AdminApi.super.reinstateUserById(userId);
    }

    @Override
    public ResponseEntity<UUID> signUpA(CreateAdminDTO createAdminDTO) {
        return AdminApi.super.signUpA(createAdminDTO);
    }

    @Override
    public ResponseEntity<Void> suspendUserById(UUID userId) {
        return AdminApi.super.suspendUserById(userId);
    }

    @Override
    public ResponseEntity<Void> updateAdminById(UUID adminId, UpdateAdminDTO updateAdminDTO) {
        return AdminApi.super.updateAdminById(adminId, updateAdminDTO);
    }

    @Override
    public ResponseEntity<Void> updateVendorById(UUID vendorId, UpdateVendorDTO updateVendorDTO) {
        return AdminApi.super.updateVendorById(vendorId, updateVendorDTO);
    }

    @Override
    public ResponseEntity<Void> verifyBusinessById(UUID businessId, BusinessVerificationDTO businessVerificationDTO) {
        return AdminApi.super.verifyBusinessById(businessId, businessVerificationDTO);
    }
}
