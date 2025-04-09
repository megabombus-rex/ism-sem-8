package jczech.pwr.ism.ism_lab02.entities.clients;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "shopping_carts")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID id;

    @Column(name = "client_id")
    public UUID clientId;
}
