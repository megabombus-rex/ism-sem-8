package jczech.pwr.ism.ism_lab02.entities.reviews;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public UUID id;

    @Column(name = "title")
    public String title;

    @Column(name = "description")
    public String description;

    @Column(name = "rating")
    public float rating;

    @Column(name = "gift_id")
    public UUID giftId;

    @Column(name = "author_id")
    public UUID authorId;

    // constructors
    public Review() { }

    public Review(String title, String description, float rating, UUID giftId, UUID authorId) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.giftId = giftId;
        this.authorId = authorId;
    }

    // getters & setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public UUID getGiftId() {
        return giftId;
    }

    public void setGiftId(UUID giftId) {
        this.giftId = giftId;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }
}
