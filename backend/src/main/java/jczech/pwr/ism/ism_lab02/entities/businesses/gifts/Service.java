package jczech.pwr.ism.ism_lab02.entities.businesses.gifts;

import jakarta.persistence.*;
import jczech.pwr.ism.ism_lab02.entities.businesses.Business;
import org.joda.time.DateTime;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "gift_id")
    public Long giftId;

    @Column(name = "business_id")
    public Long businessId;

    @Column(name = "start_date")
    public DateTime startDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gift_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Gift gift;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "service")
    private Set<ServiceSchedule> serviceSchedules = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Business business;

    // constructors
    public Service() { }

    public Service(Long giftId, Long businessId, DateTime startDate) {
        this.giftId = giftId;
        this.businessId = businessId;
        this.startDate = startDate;
    }

    // getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGiftId() {
        return giftId;
    }

    public void setGiftId(Long giftId) {
        this.giftId = giftId;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public Gift getGift() {
        return gift;
    }

    public void setGift(Gift gift) {
        this.gift = gift;
    }

    public Set<ServiceSchedule> getServiceSchedules() {
        return serviceSchedules;
    }

    public void setServiceSchedules(Set<ServiceSchedule> serviceSchedules) {
        this.serviceSchedules = serviceSchedules;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }
}
