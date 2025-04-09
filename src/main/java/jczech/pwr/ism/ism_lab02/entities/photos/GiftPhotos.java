package jczech.pwr.ism.ism_lab02.entities.photos;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "gift_photos")
public class GiftPhotos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID id;

    @Column(name = "gift_id")
    public UUID giftId;

    @Column(name = "photo_id")
    public UUID photoId;
}
