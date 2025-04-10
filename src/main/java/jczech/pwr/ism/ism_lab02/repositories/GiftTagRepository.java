package jczech.pwr.ism.ism_lab02.repositories;

import jczech.pwr.ism.ism_lab02.entities.businesses.gifts.GiftTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GiftTagRepository extends JpaRepository<GiftTag, UUID> {
}
