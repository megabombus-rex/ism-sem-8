package jczech.pwr.ism.ism_lab02.repositories;

import jczech.pwr.ism.ism_lab02.entities.businesses.gifts.ServiceSchedule;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ServiceScheduleRepository extends JpaRepository<ServiceSchedule, Long> {
}
