package jczech.pwr.ism.ism_lab02.repositories;

import jczech.pwr.ism.ism_lab02.entities.businesses.gifts.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TagRepository extends JpaRepository<Tag, Long> {


    @Query(value = "SELECT t.id FROM tags t WHERE t.name IN (:tags)", nativeQuery = true)
    List<Long> getTagIdsByNames(@Param("tags") List<String> tags);

    @Query(value = "SELECT * FROM tags WHERE name in (:tags)", nativeQuery = true)
    List<Tag> getTagsByNames(List<String> tags);
}
