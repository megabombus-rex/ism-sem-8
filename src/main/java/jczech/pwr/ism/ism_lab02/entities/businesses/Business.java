package jczech.pwr.ism.ism_lab02.entities.businesses;

import jakarta.persistence.*;
import jczech.pwr.ism.ism_lab02.entities.businesses.gifts.Gift;
import jczech.pwr.ism.ism_lab02.entities.businesses.gifts.Service;
import jczech.pwr.ism.ism_lab02.entities.users.Vendor;
import org.joda.time.DateTime;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "businesses")
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public UUID id;

    @Column(name = "initial_vendor_id")
    public UUID initialVendorId;

    @Column(name = "verification_timestamp")
    public DateTime verificationTimestamp;

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
    @JoinColumn(name = "initial_vendor_id", referencedColumnName = "id")
    private Vendor vendor;

    // constructors
    public Business() { }

    public Business(UUID initialVendorId, DateTime verificationTimestamp, String name, String emailAddress, String phoneNumber, String websiteUrl, boolean isVerified, boolean isArchived) {
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
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getInitialVendorId() {
        return initialVendorId;
    }

    public void setInitialVendorId(UUID initialVendorId) {
        this.initialVendorId = initialVendorId;
    }

    public DateTime getVerificationTimestamp() {
        return verificationTimestamp;
    }

    public void setVerificationTimestamp(DateTime verificationTimestamp) {
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
}
