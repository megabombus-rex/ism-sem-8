package jczech.pwr.ism.ism_lab02.entities.photos;

import jakarta.persistence.*;
import jczech.pwr.ism.ism_lab02.entities.businesses.gifts.Gift;
import jczech.pwr.ism.ism_lab02.entities.reviews.Review;

import java.util.UUID;

@Entity
@Table(name = "review_photos")
public class ReviewPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public UUID id;

    @Column(name = "review_id")
    public UUID reviewId;

    @Column(name = "photo_id")
    public UUID photoId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Review review;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "photo_id", referencedColumnName = "id")
    private PhotoUrl photoUrl;

    // constructors
    public ReviewPhoto() { }

    public ReviewPhoto(UUID reviewId, UUID photoId) {
        this.reviewId = reviewId;
        this.photoId = photoId;
    }

    // getters & setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getReviewId() {
        return reviewId;
    }

    public void setReviewId(UUID reviewId) {
        this.reviewId = reviewId;
    }

    public UUID getPhotoId() {
        return photoId;
    }

    public void setPhotoId(UUID photoId) {
        this.photoId = photoId;
    }
}
