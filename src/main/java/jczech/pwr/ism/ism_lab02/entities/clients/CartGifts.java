package jczech.pwr.ism.ism_lab02.entities.clients;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "cart_gifts")
public class CartGifts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID id;

    @Column(name = "cart_id")
    public UUID cartId;

    @Column(name = "gift_id")
    public UUID giftId;

    @Column(name = "count")
    public int count;
}
