package jczech.pwr.ism.ism_lab02.repositories;

import jczech.pwr.ism.ism_lab02.entities.photos.GiftPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GiftPhotoRepository extends JpaRepository<GiftPhoto, UUID> {
}
