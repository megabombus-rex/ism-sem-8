package jczech.pwr.ism.ism_lab02.repositories;

import jczech.pwr.ism.ism_lab02.entities.businesses.gifts.Service;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ServiceRepository extends JpaRepository<Service, Long> {
}
