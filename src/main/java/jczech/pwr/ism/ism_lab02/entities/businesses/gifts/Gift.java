package jczech.pwr.ism.ism_lab02.entities.businesses.gifts;

import java.util.UUID;

public class Gift {
    public UUID id;
    public UUID businessId;
    public UUID issuingVendorId;

    public String name;
    public String description;
    public float priceInPln;
    public boolean isService;
    public boolean isArchived;
}
