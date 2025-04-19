package jczech.pwr.ism.ism_lab02.services;

import jakarta.transaction.Transactional;
import jczech.pwr.ism.ism_lab02.repositories.AdminRepository;
import jczech.pwr.ism.ism_lab02.repositories.ClientRepository;
import jczech.pwr.ism.ism_lab02.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuthorizationServiceOne implements AuthorizationService{

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Long GetUserByEmail(String email, String password, String role) {
        switch (role){
            case "admin":
                break;
            case "client":

                break;
            case "vendor":
                return GetVendorByEmail(email, password);
            default:
                return 0L;
        }

        return 0L;
    }

    private Long GetVendorByEmail(String email, String password) {
        var vendor = vendorRepository.findAll().stream().filter(x -> x.getEmailAddress().equals(email)).findFirst();

        if (vendor.isEmpty())
        {
            return 0L;
        }

        if (vendor.get().getPasswordHash().equals(password)){
            return vendor.get().getId();
        }

        return 0L;
    }

    private Long GetClientByEmail(String email, String password) {
        var client = clientRepository.findAll().stream().filter(x -> x.getEmailAddress().equals(email)).findFirst();

        if (client.isEmpty())
        {
            return 0L;
        }

        if (client.get().getPasswordHash().equals(password)){
            return client.get().getId();
        }

        return 0L;
    }

    private Long GetAdminByEmail(String email, String password) {
        var admin = adminRepository.findAll().stream().filter(x -> x.getEmailAddress().equals(email)).findFirst();

        if (admin.isEmpty())
        {
            return 0L;
        }

        if (admin.get().getPasswordHash().equals(password)){
            return admin.get().getId();
        }

        return 0L;
    }
}
