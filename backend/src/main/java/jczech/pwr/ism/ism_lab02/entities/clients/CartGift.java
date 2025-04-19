package jczech.pwr.ism.ism_lab02.entities.clients;

import jakarta.persistence.*;
import jczech.pwr.ism.ism_lab02.entities.businesses.gifts.Gift;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "cart_gifts")
public class CartGift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "cart_id")
    public Long cartId;

    @Column(name = "gift_id")
    public Long giftId;

    @Column(name = "count")
    public int count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", insertable = false, updatable = false)
    private ShoppingCart shoppingCart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gift_id", insertable = false, updatable = false)
    private Gift gift;

    // constructors
    public CartGift() { }

    public CartGift(Long cartId, Long giftId, int count) {
        this.cartId = cartId;
        this.giftId = giftId;
        this.count = count;
    }

    // getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getGiftId() {
        return giftId;
    }

    public void setGiftId(Long giftId) {
        this.giftId = giftId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Gift getGift() {
        return gift;
    }

    public void setGift(Gift gift) {
        this.gift = gift;
    }
}
