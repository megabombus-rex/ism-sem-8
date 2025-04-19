package jczech.pwr.ism.ism_lab02.repositories;

import jczech.pwr.ism.ism_lab02.entities.clients.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}
