package jczech.pwr.ism.ism_lab02.entities.businesses.gifts;

import jakarta.persistence.*;
import jczech.pwr.ism.ism_lab02.entities.businesses.Business;
import jczech.pwr.ism.ism_lab02.entities.clients.Purchase;
import jczech.pwr.ism.ism_lab02.entities.photos.GiftPhoto;
import jczech.pwr.ism.ism_lab02.entities.reviews.Review;
import jczech.pwr.ism.ism_lab02.entities.users.Vendor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "gifts")
public class Gift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "gift")
    private Set<GiftTag> giftTags = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    private Service service;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "gift")
    private Set<Purchase> purchases = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "gift")
    private Set<Review> reviews = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "gift")
    private Set<GiftPhoto> giftPhotos = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id", referencedColumnName = "id")
    private Business business;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issuing_vendor_id", referencedColumnName = "id")
    private Vendor vendor;

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

    public UUID getBusinessId() {
        return businessId;
    }

    public void setBusinessId(UUID businessId) {
        this.businessId = businessId;
    }

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

    public UUID getIssuingVendorId() {
        return issuingVendorId;
    }

    public void setIssuingVendorId(UUID issuingVendorId) {
        this.issuingVendorId = issuingVendorId;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<GiftPhoto> getGiftPhotos() {
        return giftPhotos;
    }

    public void setGiftPhotos(Set<GiftPhoto> giftPhotos) {
        this.giftPhotos = giftPhotos;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
}
