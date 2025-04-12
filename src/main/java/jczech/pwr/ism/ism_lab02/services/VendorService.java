package jczech.pwr.ism.ism_lab02.services;

import jczech.pwr.ism.model.CreateBusinessDTO;
import jczech.pwr.ism.model.CreateVendorDTO;



public interface VendorService {
    public Long createNewVendor(CreateVendorDTO createVendorDTO);

    public Long registerBusiness(Long vendorId, CreateBusinessDTO createBusinessDTO);
}
