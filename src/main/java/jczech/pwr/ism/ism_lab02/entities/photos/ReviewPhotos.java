package jczech.pwr.ism.ism_lab02.entities.photos;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "review_photos")
public class ReviewPhotos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID id;

    @Column(name = "review_id")
    public UUID reviewId;

    @Column(name = "photo_id")
    public UUID photoId;
}
