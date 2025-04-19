package jczech.pwr.ism.ism_lab02.repositories;

import jczech.pwr.ism.ism_lab02.entities.photos.PhotoUrl;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PhotoUrlRepository extends JpaRepository<PhotoUrl, Long> {
}
