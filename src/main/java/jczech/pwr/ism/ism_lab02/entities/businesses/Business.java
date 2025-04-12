package jczech.pwr.ism.ism_lab02.entities.businesses;

import jakarta.persistence.*;
import jczech.pwr.ism.ism_lab02.entities.businesses.gifts.Gift;
import jczech.pwr.ism.ism_lab02.entities.businesses.gifts.Service;
import jczech.pwr.ism.ism_lab02.entities.users.Vendor;
import org.joda.time.DateTime;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "businesses")
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "initial_vendor_id")
    public Long initialVendorId;

    @Column(name = "verification_timestamp")
    public Timestamp verificationTimestamp;

    @Column(name = "name")
    public String name;

    @Column(name = "email_address")
    public String emailAddress;

    @Column(name = "phone_number")
    public String phoneNumber;

    @Column(name = "website_url")
    public String websiteUrl;

    @Column(name = "is_verified")
    public boolean isVerified;

    @Column(name = "is_archived")
    public boolean isArchived;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "business")
    private Set<Service> services = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "business")
    private Set<Gift> gifts = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "initial_vendor_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Vendor vendor;

    // constructors
    public Business() { }

    public Business(Long initialVendorId, Timestamp verificationTimestamp, String name, String emailAddress, String phoneNumber, String websiteUrl, boolean isVerified, boolean isArchived) {
        this.initialVendorId = initialVendorId;
        this.verificationTimestamp = verificationTimestamp;
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.websiteUrl = websiteUrl;
        this.isVerified = isVerified;
        this.isArchived = isArchived;
    }

    // getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInitialVendorId() {
        return initialVendorId;
    }

    public void setInitialVendorId(Long initialVendorId) {
        this.initialVendorId = initialVendorId;
    }

    public Timestamp getVerificationTimestamp() {
        return verificationTimestamp;
    }

    public void setVerificationTimestamp(Timestamp verificationTimestamp) {
        this.verificationTimestamp = verificationTimestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }

    public Set<Gift> getGifts() {
        return gifts;
    }

    public void setGifts(Set<Gift> gifts) {
        this.gifts = gifts;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
}
