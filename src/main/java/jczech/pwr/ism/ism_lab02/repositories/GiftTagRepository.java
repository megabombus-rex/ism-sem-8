package jczech.pwr.ism.ism_lab02.repositories;

import jczech.pwr.ism.ism_lab02.entities.businesses.gifts.GiftTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface GiftTagRepository extends JpaRepository<GiftTag, Long> {
    @Query(value = "SELECT gt.tag_id from gift_tags as gt", nativeQuery = true)
    public List<GiftTag> findByGiftId(Long giftId);
}
