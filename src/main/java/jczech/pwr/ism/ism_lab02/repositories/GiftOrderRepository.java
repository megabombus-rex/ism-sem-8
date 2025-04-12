package jczech.pwr.ism.ism_lab02.repositories;

import jczech.pwr.ism.ism_lab02.entities.businesses.gifts.GiftOrder;
import org.springframework.data.jpa.repository.JpaRepository;



public interface GiftOrderRepository extends JpaRepository<GiftOrder, Long> {
}
