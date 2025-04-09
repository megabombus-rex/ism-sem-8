package jczech.pwr.ism.ism_lab02.entities.businesses.gifts;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "gift_orders")
public class GiftOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public UUID id;

    @Column(name = "order_id")
    public UUID orderId;

    @Column(name = "gift_id")
    public UUID giftId;

    // constructors
    public GiftOrder() { }

    public GiftOrder(UUID orderId, UUID giftId)
    {
        this.orderId = orderId;
        this.giftId = giftId;
    }

    // getters & setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getGiftId() {
        return giftId;
    }

    public void setGiftId(UUID giftId) {
        this.giftId = giftId;
    }
}
