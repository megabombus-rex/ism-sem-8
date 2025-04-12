package jczech.pwr.ism.ism_lab02.repositories;

import jczech.pwr.ism.ism_lab02.entities.clients.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
