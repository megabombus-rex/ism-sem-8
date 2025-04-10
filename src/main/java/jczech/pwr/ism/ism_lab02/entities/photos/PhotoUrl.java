package jczech.pwr.ism.ism_lab02.entities.photos;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "photo_urls")
public class PhotoUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public UUID id;

    @Column(name = "photo_url")
    public String photoUrl;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "photo_id", referencedColumnName = "id")
    private GiftPhoto giftPhoto;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "photo_id", referencedColumnName = "id")
    private ReviewPhoto reviewPhoto;

    // constructors
    public PhotoUrl() { }

    public PhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    // getters & setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public GiftPhoto getGiftPhoto() {
        return giftPhoto;
    }

    public void setGiftPhoto(GiftPhoto giftPhoto) {
        this.giftPhoto = giftPhoto;
    }

    public ReviewPhoto getReviewPhoto() {
        return reviewPhoto;
    }

    public void setReviewPhoto(ReviewPhoto reviewPhoto) {
        this.reviewPhoto = reviewPhoto;
    }
}
