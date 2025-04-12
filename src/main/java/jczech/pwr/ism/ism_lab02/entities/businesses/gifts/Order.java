package jczech.pwr.ism.ism_lab02.entities.businesses.gifts;

import jakarta.persistence.*;
import jczech.pwr.ism.ism_lab02.entities.users.Client;
import jczech.pwr.ism.ism_lab02.entities.users.Vendor;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "vendor_id")
    public Long vendorId;

    @Column(name = "client_id")
    public Long clientId;

    @Column(name = "provider_id")
    public Long providerId;

    @Column(name = "status")
    public String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Vendor vendor;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private Set<GiftOrder> giftOrders = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ShippingProvider shippingProvider;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Client client;

    // constructors
    public Order() { }

    public Order(Long vendorId, Long clientId, Long providerId, String status) {
        this.vendorId = vendorId;
        this.clientId = clientId;
        this.providerId = providerId;
        this.status = status;
    }


    // getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Set<GiftOrder> getGiftOrders() {
        return giftOrders;
    }

    public void setGiftOrders(Set<GiftOrder> giftOrders) {
        this.giftOrders = giftOrders;
    }

    public ShippingProvider getShippingProvider() {
        return shippingProvider;
    }

    public void setShippingProvider(ShippingProvider shippingProvider) {
        this.shippingProvider = shippingProvider;
    }
}
