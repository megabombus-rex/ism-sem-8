package jczech.pwr.ism.ism_lab02.controllers;

import jczech.pwr.ism.api.VendorApi;
import jczech.pwr.ism.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class VendorController implements VendorApi {

    @Override
    public ResponseEntity<UUID> createVendor(CreateVendorDTO createVendorDTO) {
        return VendorApi.super.createVendor(createVendorDTO);
    }
    @Override
    public ResponseEntity<List<GetAllVendors200ResponseInner>> getAllVendors(Integer page, Integer count, String vendorName) {
        return VendorApi.super.getAllVendors(page, count, vendorName);
    }

    @Override
    public ResponseEntity<GetBusinessDTO> getBusinessById(UUID businessId) {
        return VendorApi.super.getBusinessById(businessId);
    }

    @Override
    public ResponseEntity<OrderStatusDTO> getOrderStatusById(UUID orderId, UUID vendorId) {
        return VendorApi.super.getOrderStatusById(orderId, vendorId);
    }

    @Override
    public ResponseEntity<GetVendorDTO> getVendorAccount(UUID vendorId) {
        return VendorApi.super.getVendorAccount(vendorId);
    }

    @Override
    public ResponseEntity<List<SearchGiftsByTags200ResponseInner>> getVendorGifts(UUID vendorId, Integer page, Integer count) {
        return VendorApi.super.getVendorGifts(vendorId, page, count);
    }

    @Override
    public ResponseEntity<List<GetVendorOrders200ResponseInner>> getVendorOrders(UUID vendorId, Integer page, Integer count) {
        return VendorApi.super.getVendorOrders(vendorId, page, count);
    }

    @Override
    public ResponseEntity<UUID> registerBusiness(UUID vendorId, CreateBusinessDTO createBusinessDTO) {
        return VendorApi.super.registerBusiness(vendorId, createBusinessDTO);
    }

    @Override
    public ResponseEntity<UUID> signUpV(CreateVendorDTO createVendorDTO) {
        return VendorApi.super.signUpV(createVendorDTO);
    }
}
