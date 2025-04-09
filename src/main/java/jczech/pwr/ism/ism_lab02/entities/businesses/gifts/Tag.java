package jczech.pwr.ism.ism_lab02.entities.businesses.gifts;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public UUID id;

    @Column(name = "name")
    public String name;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tag")
    private Set<GiftTag> giftTags = new HashSet<>();

    // constructors
    public Tag() { }

    public Tag(String name) {
        this.name = name;
    }

    // getters & setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<GiftTag> getGiftTags() {
        return giftTags;
    }

    public void setGiftTags(Set<GiftTag> giftTags) {
        this.giftTags = giftTags;
    }
}
