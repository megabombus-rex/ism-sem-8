package jczech.pwr.ism.ism_lab02.entities.clients;

import jakarta.persistence.*;
import jczech.pwr.ism.ism_lab02.entities.users.Client;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "shopping_carts")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "client_id")
    public Long clientId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Client client;

    @OneToMany(mappedBy = "shoppingCart", fetch = FetchType.LAZY)
    private Set<CartGift> cartGifts = new HashSet<>();

    // constructors
    public ShoppingCart() { }

    public ShoppingCart(Long clientId) {
        this.clientId = clientId;
    }

    // getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<CartGift> getCartGifts() {
        return cartGifts;
    }

    public void setCartGifts(Set<CartGift> cartGifts) {
        this.cartGifts = cartGifts;
    }
}
