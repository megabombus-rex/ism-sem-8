package jczech.pwr.ism.ism_lab02.entities.businesses.gifts;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "gift_orders")
public class GiftOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID id;

    @Column(name = "order_id")
    public UUID orderId;

    @Column(name = "gift_id")
    public UUID giftId;
}
