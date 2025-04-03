package jczech.pwr.ism.ism_lab02.entities.reviews;

import java.util.UUID;

public class Review {
    public UUID id;
    public String title;
    public String description;
    public float rating;
    public UUID giftId;
    public UUID authorId;
}
