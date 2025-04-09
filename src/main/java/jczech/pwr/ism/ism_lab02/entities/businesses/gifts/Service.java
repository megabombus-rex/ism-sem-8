package jczech.pwr.ism.ism_lab02.entities.businesses.gifts;

import jakarta.persistence.*;
import jczech.pwr.ism.ism_lab02.entities.businesses.Business;
import org.joda.time.DateTime;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public UUID id;

    @Column(name = "gift_id")
    public UUID giftId;

    @Column(name = "business_id")
    public UUID businessId;

    @Column(name = "start_date")
    public DateTime startDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gift_id", referencedColumnName = "id")
    private Gift gift;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "service")
    private Set<ServiceSchedule> serviceSchedules = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id", referencedColumnName = "id")
    private Business business;

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
