package jczech.pwr.ism.ism_lab02.entities.clients;

import jakarta.persistence.*;
import jczech.pwr.ism.ism_lab02.entities.businesses.gifts.Gift;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "cart_gifts")
public class CartGift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public UUID id;

    @Column(name = "cart_id")
    public UUID cartId;

    @Column(name = "gift_id")
    public UUID giftId;

    @Column(name = "count")
    public int count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private ShoppingCart shoppingCart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gift_id")
    private Gift gift;

    // constructors
    public CartGift() { }

    public CartGift(UUID cartId, UUID giftId, int count) {
        this.cartId = cartId;
        this.giftId = giftId;
        this.count = count;
    }

    // getters & setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getCartId() {
        return cartId;
    }

    public void setCartId(UUID cartId) {
        this.cartId = cartId;
    }

    public UUID getGiftId() {
        return giftId;
    }

    public void setGiftId(UUID giftId) {
        this.giftId = giftId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
