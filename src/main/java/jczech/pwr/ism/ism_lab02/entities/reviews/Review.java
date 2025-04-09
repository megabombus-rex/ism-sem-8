package jczech.pwr.ism.ism_lab02.entities.reviews;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
