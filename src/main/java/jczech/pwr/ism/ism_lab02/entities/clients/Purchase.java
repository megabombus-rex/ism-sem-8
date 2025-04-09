package jczech.pwr.ism.ism_lab02.entities.clients;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public UUID id;

    @Column(name = "gift_id")
    public UUID giftId;

    // constructors
    public Purchase() { }

    public Purchase(UUID giftId) {
        this.giftId = giftId;
    }

    // getters & setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getGiftId() {
        return giftId;
    }

    public void setGiftId(UUID giftId) {
        this.giftId = giftId;
    }
}
