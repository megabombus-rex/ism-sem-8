package jczech.pwr.ism.ism_lab02.repositories;

import jczech.pwr.ism.ism_lab02.entities.businesses.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BusinessRepository extends JpaRepository<Business, Long> {

    @Query(value = "SELECT * FROM businesses WHERE initial_vendor_id = :vendorId", nativeQuery = true)
    public List<Business> findByInitialVendorId(Long vendorId);
}
