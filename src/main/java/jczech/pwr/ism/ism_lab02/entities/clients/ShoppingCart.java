package jczech.pwr.ism.ism_lab02.entities.clients;

import jakarta.persistence.*;
import jczech.pwr.ism.ism_lab02.entities.users.Client;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "shopping_carts")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public UUID id;

    @Column(name = "client_id")
    public UUID clientId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "shopping_cart", fetch = FetchType.LAZY)
    private Set<CartGift> cartGifts = new HashSet<>();

    // constructors
    public ShoppingCart() { }

    public ShoppingCart(UUID clientId) {
        this.clientId = clientId;
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
}
