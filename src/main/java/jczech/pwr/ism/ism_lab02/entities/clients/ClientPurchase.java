package jczech.pwr.ism.ism_lab02.entities.clients;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "client_purchases")
public class ClientPurchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public UUID id;

    @Column(name = "client_id")
    public UUID clientId;

    @Column(name = "purchase_id")
    public UUID purchaseId;

    // constructors
    public ClientPurchase() { }

    public ClientPurchase(UUID clientId, UUID purchaseId) {
        this.clientId = clientId;
        this.purchaseId = purchaseId;
    }

    // getters & setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public UUID getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(UUID purchaseId) {
        this.purchaseId = purchaseId;
    }
}
