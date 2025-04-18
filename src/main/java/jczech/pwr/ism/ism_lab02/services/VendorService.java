package jczech.pwr.ism.ism_lab02.services;

import jczech.pwr.ism.model.CreateBusinessDTO;
import jczech.pwr.ism.model.CreateVendorDTO;
import jczech.pwr.ism.model.GetBusinessDTO;

import java.util.List;


public interface VendorService {
    public Long createNewVendor(CreateVendorDTO createVendorDTO);

    public Long registerBusiness(Long vendorId, CreateBusinessDTO createBusinessDTO);

    public GetBusinessDTO getBusinessByVendorId(Long vendorId);
}
