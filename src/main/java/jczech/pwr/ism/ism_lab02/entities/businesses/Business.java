package jczech.pwr.ism.ism_lab02.entities.businesses;

import org.joda.time.DateTime;

import java.util.UUID;

public class Business {
    public UUID id;
    public UUID initialVendorId;
    public DateTime verificationTimestamp;

    public String name;
    public String emailAddress;
    public String phoneNumber;
    public String websiteUrl;

    public boolean isVerified;
    public boolean isArchived;
}
