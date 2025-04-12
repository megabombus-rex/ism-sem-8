package jczech.pwr.ism.ism_lab02.controllers;

import jczech.pwr.ism.api.VendorApi;
import jczech.pwr.ism.ism_lab02.services.VendorService;
import jczech.pwr.ism.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;


@RestController
public class VendorController implements VendorApi {

    @Autowired
    VendorService vendorService;

    @Override
    public ResponseEntity<Long> createVendor(CreateVendorDTO createVendorDTO) {
        var id = vendorService.createNewVendor(createVendorDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }
    @Override
    public ResponseEntity<List<GetAllVendors200ResponseInner>> getAllVendors(Integer page, Integer count, String vendorName) {
        return VendorApi.super.getAllVendors(page, count, vendorName);
    }

    @Override
    public ResponseEntity<GetBusinessDTO> getBusinessById(Long businessId) {
        return VendorApi.super.getBusinessById(businessId);
    }

    @Override
    public ResponseEntity<OrderStatusDTO> getOrderStatusById(Long orderId, Long vendorId) {
        return VendorApi.super.getOrderStatusById(orderId, vendorId);
    }

    @Override
    public ResponseEntity<GetVendorDTO> getVendorAccount(Long vendorId) {
        return VendorApi.super.getVendorAccount(vendorId);
    }

    @Override
    public ResponseEntity<List<SearchGiftsByTags200ResponseInner>> getVendorGifts(Long vendorId, Integer page, Integer count) {
        return VendorApi.super.getVendorGifts(vendorId, page, count);
    }

    @Override
    public ResponseEntity<List<GetVendorOrders200ResponseInner>> getVendorOrders(Long vendorId, Integer page, Integer count) {
        return VendorApi.super.getVendorOrders(vendorId, page, count);
    }

    @Override
    public ResponseEntity<Long> signUpV(CreateVendorDTO createVendorDTO) {
        var id = vendorService.createNewVendor(createVendorDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @Override
    public ResponseEntity<Long> registerBusiness(Long vendorId, CreateBusinessDTO createBusinessDTO) {
        var response = vendorService.registerBusiness(vendorId, createBusinessDTO);

        if (response == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
