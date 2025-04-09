package jczech.pwr.ism.ism_lab02.entities.businesses.gifts;

import jakarta.persistence.*;
import org.joda.time.DateTime;

import java.util.UUID;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID id;

    @Column(name = "gift_id")
    public UUID giftId;

    @Column(name = "business_id")
    public UUID businessId;

    @Column(name = "start_date")
    public DateTime startDate;

    // constructors
    public Service() { }

    public Service(UUID giftId, UUID businessId, DateTime startDate) {
        this.giftId = giftId;
        this.businessId = businessId;
        this.startDate = startDate;
    }

    // getters & setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getGiftId() {
        return giftId;
    }

    public void setGiftId(UUID giftId) {
        this.giftId = giftId;
    }

    public UUID getBusinessId() {
        return businessId;
    }

    public void setBusinessId(UUID businessId) {
        this.businessId = businessId;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }
}
