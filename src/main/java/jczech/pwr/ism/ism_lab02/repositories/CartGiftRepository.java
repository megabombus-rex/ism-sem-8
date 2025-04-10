package jczech.pwr.ism.ism_lab02.repositories;

import jczech.pwr.ism.ism_lab02.entities.clients.CartGift;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartGiftRepository extends JpaRepository<CartGift, UUID> {
}
