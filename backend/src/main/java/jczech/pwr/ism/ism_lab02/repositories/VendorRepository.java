package jczech.pwr.ism.ism_lab02.repositories;

import jczech.pwr.ism.ism_lab02.entities.users.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;



public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
