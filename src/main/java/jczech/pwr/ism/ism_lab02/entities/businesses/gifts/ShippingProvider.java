package jczech.pwr.ism.ism_lab02.entities.businesses.gifts;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "shipping_providers")
public class ShippingProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public UUID id;

    @Column(name = "name")
    public String name;

    // constructors
    public ShippingProvider() { }

    public ShippingProvider(String name) {
        this.name = name;
    }

    // getters & setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
