package jczech.pwr.ism.ism_lab02.entities.photos;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "gift_photos")
public class GiftPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public UUID id;

    @Column(name = "gift_id")
    public UUID giftId;

    @Column(name = "photo_id")
    public UUID photoId;

    // constructors
    public GiftPhoto() { }

    public GiftPhoto(UUID giftId, UUID photoId) {
        this.giftId = giftId;
        this.photoId = photoId;
    }

    // getters & setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getGiftId() {
        return giftId;
    }

    public void setGiftId(UUID giftId) {
        this.giftId = giftId;
    }

    public UUID getPhotoId() {
        return photoId;
    }

    public void setPhotoId(UUID photoId) {
        this.photoId = photoId;
    }
}
