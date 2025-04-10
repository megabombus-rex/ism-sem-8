package jczech.pwr.ism.ism_lab02.entities.clients;

import jakarta.persistence.*;
import jczech.pwr.ism.ism_lab02.entities.businesses.gifts.Gift;
import org.joda.time.DateTime;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public UUID id;

    @Column(name = "gift_id")
    public UUID giftId;

    @Column(name = "purchase_date")
    public DateTime purchaseDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gift_id")
    private Gift gift;

    @OneToMany(mappedBy = "purchase")
    private Set<ClientPurchase> clientPurchases = new HashSet<>();

    // constructors
    public Purchase() { }

    public Purchase(UUID giftId) {
        this.giftId = giftId;
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
