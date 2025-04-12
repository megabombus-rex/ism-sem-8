package jczech.pwr.ism.ism_lab02.controllers;

import jczech.pwr.ism.api.AdminApi;
import jczech.pwr.ism.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;


@RestController
public class AdminController implements AdminApi {
    @Override
    public ResponseEntity<Void> reinstateUserById(Long userId, String role) {
        return AdminApi.super.reinstateUserById(userId, role);
    }

    @Override
    public ResponseEntity<Long> createAdmin(CreateAdminDTO createAdminDTO) {
        return AdminApi.super.createAdmin(createAdminDTO);
    }

    @Override
    public ResponseEntity<Void> deleteUserById(Long userId, String role) {
        return AdminApi.super.deleteUserById(userId, role);
    }

    @Override
    public ResponseEntity<GetAdminDTO> getAdminById(Long adminId) {
        return AdminApi.super.getAdminById(adminId);
    }

    @Override
    public ResponseEntity<GetVendorDTO> getVendorById(Long vendorId) {
        return AdminApi.super.getVendorById(vendorId);
    }


    @Override
    public ResponseEntity<Long> signUpA(CreateAdminDTO createAdminDTO) {
        return AdminApi.super.signUpA(createAdminDTO);
    }


    @Override
    public ResponseEntity<Void> updateAdminById(Long adminId, UpdateAdminDTO updateAdminDTO) {
        return AdminApi.super.updateAdminById(adminId, updateAdminDTO);
    }

    @Override
    public ResponseEntity<Void> updateVendorById(Long vendorId, UpdateVendorDTO updateVendorDTO) {
        return AdminApi.super.updateVendorById(vendorId, updateVendorDTO);
    }

    @Override
    public ResponseEntity<Void> verifyBusinessById(Long businessId, BusinessVerificationDTO businessVerificationDTO) {
        return AdminApi.super.verifyBusinessById(businessId, businessVerificationDTO);
    }
}
