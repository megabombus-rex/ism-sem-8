package jczech.pwr.ism.ism_lab02.repositories;

import jczech.pwr.ism.ism_lab02.entities.photos.ReviewPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewPhotoRepository extends JpaRepository<ReviewPhoto, UUID> {
}
