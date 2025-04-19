package jczech.pwr.ism.ism_lab02.repositories;

import jczech.pwr.ism.ism_lab02.entities.clients.ClientPurchase;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ClientPurchaseRepository extends JpaRepository<ClientPurchase, Long> {
}
