package jczech.pwr.ism.ism_lab02.entities.reviews;

import jakarta.persistence.*;
import jczech.pwr.ism.ism_lab02.entities.businesses.gifts.Gift;
import jczech.pwr.ism.ism_lab02.entities.photos.ReviewPhoto;
import jczech.pwr.ism.ism_lab02.entities.users.Client;

import java.util.HashSet;
import java.util.Set;
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

    @Column(name = "used_gift_id")
    public UUID usedGiftId;

    @Column(name = "author_id")
    public UUID authorId;

    @OneToMany(mappedBy = "review", fetch = FetchType.LAZY)
    private Set<ReviewPhoto> reviewPhotos = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Client postingClient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "used_gift_id")
    private Gift gift;

    // constructors
    public Review() { }

    public Review(String title, String description, float rating, UUID usedGiftId, UUID authorId) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.usedGiftId = usedGiftId;
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

    public UUID getUsedGiftId() {
        return usedGiftId;
    }

    public void setUsedGiftId(UUID giftId) {
        this.usedGiftId = giftId;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }

    public Set<ReviewPhoto> getReviewPhotos() {
        return reviewPhotos;
    }

    public void setReviewPhotos(Set<ReviewPhoto> reviewPhotos) {
        this.reviewPhotos = reviewPhotos;
    }

    public Client getPostingClient() {
        return postingClient;
    }

    public void setPostingClient(Client postingClient) {
        this.postingClient = postingClient;
    }

    public Gift getGift() {
        return gift;
    }

    public void setGift(Gift gift) {
        this.gift = gift;
    }
}
