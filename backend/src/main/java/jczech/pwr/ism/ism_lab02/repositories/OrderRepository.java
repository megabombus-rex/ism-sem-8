package jczech.pwr.ism.ism_lab02.repositories;

import jczech.pwr.ism.ism_lab02.entities.businesses.gifts.Order;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderRepository extends JpaRepository<Order, Long> {
}
