package jczech.pwr.ism.ism_lab02.repositories;

import jczech.pwr.ism.ism_lab02.entities.businesses.gifts.ShippingProvider;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ShippingProviderRepository extends JpaRepository<ShippingProvider, Long> {
}
