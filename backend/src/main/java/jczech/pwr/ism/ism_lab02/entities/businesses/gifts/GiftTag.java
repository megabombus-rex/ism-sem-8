package jczech.pwr.ism.ism_lab02.entities.businesses.gifts;

import jakarta.persistence.*;



@Entity
@Table(name = "gift_tags")
public class GiftTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "tag_id")
    public Long tagId;

    @Column(name = "gift_id")
    public Long giftId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gift_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Gift gift;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Tag tag;

    // constructors
    public GiftTag() {}

    public GiftTag(Long tagId, Long giftId) {
        this.tagId = tagId;
        this.giftId = giftId;
    }

    // getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public Long getGiftId() {
        return giftId;
    }

    public void setGiftId(Long giftId) {
        this.giftId = giftId;
    }

    public Gift getGift() {
        return gift;
    }

    public void setGift(Gift gift) {
        this.gift = gift;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
