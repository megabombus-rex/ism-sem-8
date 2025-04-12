package jczech.pwr.ism.ism_lab02.entities.clients;

import jakarta.persistence.*;
import jczech.pwr.ism.ism_lab02.entities.businesses.gifts.Gift;
import org.joda.time.DateTime;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "gift_id")
    public Long giftId;

    @Column(name = "purchase_date")
    public DateTime purchaseDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gift_id", insertable = false, updatable = false)
    private Gift gift;

    @OneToMany(mappedBy = "purchase")
    private Set<ClientPurchase> clientPurchases = new HashSet<>();

    // constructors
    public Purchase() { }

    public Purchase(Long giftId) {
        this.giftId = giftId;
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

    public DateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(DateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Gift getGift() {
        return gift;
    }

    public void setGift(Gift gift) {
        this.gift = gift;
    }

    public Set<ClientPurchase> getClientPurchases() {
        return clientPurchases;
    }

    public void setClientPurchases(Set<ClientPurchase> clientPurchases) {
        this.clientPurchases = clientPurchases;
    }
}
