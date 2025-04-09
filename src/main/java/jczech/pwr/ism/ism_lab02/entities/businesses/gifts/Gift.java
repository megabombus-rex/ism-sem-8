package jczech.pwr.ism.ism_lab02.entities.businesses.gifts;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "gifts")
public class Gift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID id;

    @Column(name = "business_id", nullable = false)
    public UUID businessId;

    @Column(name = "issuing_vendor_id", nullable = false)
    public UUID issuingVendorId;

    @Column(name = "name")
    public String name;
    @Column(name = "description")
    public String description;
    @Column(name = "price_in_pln")
    public float priceInPln;
    @Column(name = "is_service")
    public boolean isService;
    @Column(name = "is_archived")
    public boolean isArchived;

    @OneToMany(mappedBy = "gift")
    @JoinColumn(name = "gift_id")
    private Set<GiftTag> giftTags = new HashSet<>();

    // constructors
    public Gift() { }

    public Gift(UUID businessId, UUID issuingVendorId, String name, String description, float priceInPln, boolean isService, boolean isArchived) {
        this.businessId = businessId;
        this.issuingVendorId = issuingVendorId;
        this.name = name;
        this.description = description;
        this.priceInPln = priceInPln;
        this.isService = isService;
        this.isArchived = isArchived;
    }

    // getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPriceInPln() {
        return priceInPln;
    }

    public void setPriceInPln(float priceInPln) {
        this.priceInPln = priceInPln;
    }

    public boolean isService() {
        return isService;
    }

    public void setService(boolean service) {
        isService = service;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    public Set<GiftTag> getGiftTags() {
        return giftTags;
    }

    public void setGiftTags(Set<GiftTag> giftTags) {
        this.giftTags = giftTags;
    }
}
