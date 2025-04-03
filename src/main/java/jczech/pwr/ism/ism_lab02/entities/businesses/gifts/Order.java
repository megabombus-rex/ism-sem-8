package jczech.pwr.ism.ism_lab02.entities.businesses.gifts;

import java.util.UUID;

public class Order {
    public UUID id;
    public UUID vendorId;
    public UUID clientId;
    public UUID orderedGiftId;
    public UUID providerId;
    public String status;
}
