package jczech.pwr.ism.ism_lab02.entities.reviews;

import jakarta.persistence.*;
import jczech.pwr.ism.ism_lab02.entities.businesses.gifts.Gift;
import jczech.pwr.ism.ism_lab02.entities.photos.ReviewPhoto;
import jczech.pwr.ism.ism_lab02.entities.users.Client;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "title")
    public String title;

    @Column(name = "description")
    public String description;

    @Column(name = "rating")
    public float rating;

    @Column(name = "used_gift_id")
    public Long usedGiftId;

    @Column(name = "author_id")
    public Long authorId;

    @OneToMany(mappedBy = "review", fetch = FetchType.LAZY)
    private Set<ReviewPhoto> reviewPhotos = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    private Client postingClient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "used_gift_id", insertable = false, updatable = false)
    private Gift gift;

    // constructors
    public Review() { }

    public Review(String title, String description, float rating, Long usedGiftId, Long authorId) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.usedGiftId = usedGiftId;
        this.authorId = authorId;
    }

    // getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getUsedGiftId() {
        return usedGiftId;
    }

    public void setUsedGiftId(Long giftId) {
        this.usedGiftId = giftId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
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
