package jczech.pwr.ism.ism_lab02.entities.businesses.gifts;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "gift_tags")
public class GiftTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public UUID id;

    @Column(name = "tag_id")
    public UUID tagId;

    @Column(name = "gift_id")
    public UUID giftId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gift_id")
    private Gift gift;

    // constructors
    public GiftTag() {}

    public GiftTag(UUID tagId, UUID giftId) {
        this.tagId = tagId;
        this.giftId = giftId;
    }

    // getters & setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getTagId() {
        return tagId;
    }

    public void setTagId(UUID tagId) {
        this.tagId = tagId;
    }

    public UUID getGiftId() {
        return giftId;
    }

    public void setGiftId(UUID giftId) {
        this.giftId = giftId;
    }
}
