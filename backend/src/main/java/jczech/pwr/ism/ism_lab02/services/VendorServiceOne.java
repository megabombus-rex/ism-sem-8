package jczech.pwr.ism.ism_lab02.services;

import jakarta.transaction.Transactional;
import jczech.pwr.ism.ism_lab02.entities.businesses.Business;
import jczech.pwr.ism.ism_lab02.entities.users.Role;
import jczech.pwr.ism.ism_lab02.entities.users.Vendor;
import jczech.pwr.ism.ism_lab02.repositories.BusinessRepository;
import jczech.pwr.ism.ism_lab02.repositories.RoleRepository;
import jczech.pwr.ism.ism_lab02.repositories.VendorRepository;
import jczech.pwr.ism.model.CreateBusinessDTO;
import jczech.pwr.ism.model.CreateVendorDTO;
import jczech.pwr.ism.model.GetBusinessDTO;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;


@Service
@Transactional
public class VendorServiceOne implements VendorService {

    @Autowired
    VendorRepository vendorRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BusinessRepository businessRepository;

    @Override
    public Long createNewVendor(CreateVendorDTO createVendorDTO)
    {
        var role = roleRepository.findAll().stream().filter(x -> x.name.equals("vendor")).findFirst();

        if (role.isEmpty()){
            var newRole = new Role();
            newRole.name = "vendor";

            roleRepository.save(newRole);
            roleRepository.flush();
            role = roleRepository.findAll().stream().filter(x -> x.name.equals("vendor")).findFirst();
        }

        var vendor = new Vendor(createVendorDTO.getProfession(), createVendorDTO.getFirstName(), createVendorDTO.getLastName(), createVendorDTO.getEmail(), createVendorDTO.getPassword(), role.get().getId());

        vendorRepository.save(vendor);
        vendorRepository.flush();

        return vendor.getId();
    }

    @Override
    public Long registerBusiness(Long vendorId, CreateBusinessDTO createBusinessDTO) {
        if (!vendorRepository.findById(vendorId).isPresent()){
            return null;
        }

        var bus = businessRepository.findByInitialVendorId(vendorId);

        if (bus.stream().anyMatch(x -> !x.isArchived)){
            System.out.println("This vendor has an active business right now.");
            return null;
        }

        var business = new Business();
        business.setInitialVendorId(vendorId);
        business.setName(createBusinessDTO.getName());
        business.setWebsiteUrl(createBusinessDTO.getWebsiteUrl());
        business.setEmailAddress(createBusinessDTO.getEmail());
        business.setPhoneNumber(createBusinessDTO.getPhoneNumber());
        business.setVerificationTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        business.setArchived(false);

        businessRepository.save(business);
        businessRepository.flush();

        return business.getId();
    }

    @Override
    public GetBusinessDTO getBusinessByVendorId(Long vendorId) {
        if (!vendorRepository.findById(vendorId).isPresent()){
            return null;
        }

        var businesses = businessRepository.findByInitialVendorId(vendorId);

        if (businesses.stream().allMatch(x -> x.isArchived))
        {
           System.out.println("This vendor has an active business right now.");
           return null;
        }

        var currentBusiness = businesses.stream().filter(x -> !x.isArchived).findFirst();

        var dto = new GetBusinessDTO();
        dto.setBusinessId(currentBusiness.get().getId());
        dto.setApplicantId(currentBusiness.get().getInitialVendorId());
        dto.setName(currentBusiness.get().getName());
        dto.setEmail(currentBusiness.get().getEmailAddress());
        dto.setPhoneNumber(currentBusiness.get().getPhoneNumber());
        dto.setWebsiteUrl(currentBusiness.get().getWebsiteUrl());
        dto.setIsVerified(currentBusiness.get().isVerified());
        dto.verificationTimestamp(OffsetDateTime.ofInstant(Instant.ofEpochMilli(currentBusiness.get().getVerificationTimestamp().getTime()), ZoneId.of("UTC")));

        return dto;
    }
}
