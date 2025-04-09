package jczech.pwr.ism.ism_lab02.entities.businesses.gifts;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public UUID id;

    @Column(name = "vendor_id")
    public UUID vendorId;

    @Column(name = "client_id")
    public UUID clientId;

    @Column(name = "provider_id")
    public UUID providerId;

    @Column(name = "status")
    public String status;

    // constructors
    public Order() { }

    public Order(UUID vendorId, UUID clientId, UUID providerId, String status) {
        this.vendorId = vendorId;
        this.clientId = clientId;
        this.providerId = providerId;
        this.status = status;
    }


    // getters & setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getVendorId() {
        return vendorId;
    }

    public void setVendorId(UUID vendorId) {
        this.vendorId = vendorId;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public UUID getProviderId() {
        return providerId;
    }

    public void setProviderId(UUID providerId) {
        this.providerId = providerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
