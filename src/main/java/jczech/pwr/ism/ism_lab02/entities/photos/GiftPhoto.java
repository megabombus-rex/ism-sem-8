package jczech.pwr.ism.ism_lab02.entities.photos;

import jakarta.persistence.*;
import jczech.pwr.ism.ism_lab02.entities.businesses.gifts.Gift;

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

    @OneToOne(fetch = FetchType.LAZY)
    private PhotoUrl photoUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    private Gift gift;

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

    public PhotoUrl getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(PhotoUrl photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Gift getGift() {
        return gift;
    }

    public void setGift(Gift gift) {
        this.gift = gift;
    }
}
