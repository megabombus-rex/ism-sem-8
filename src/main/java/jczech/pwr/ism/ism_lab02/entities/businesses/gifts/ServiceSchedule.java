package jczech.pwr.ism.ism_lab02.entities.businesses.gifts;

import jakarta.persistence.*;
import jczech.pwr.ism.ism_lab02.entities.users.Client;

import java.util.UUID;

@Entity
@Table(name = "service_schedules")
public class ServiceSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public UUID id;

    @Column(name = "service_id")
    public UUID serviceId;

    @Column(name = "client_id")
    public UUID clientId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    private Service service;


    // constructors
    public ServiceSchedule() { }

    public ServiceSchedule(UUID serviceId, UUID clientId) {
        this.serviceId = serviceId;
        this.clientId = clientId;
    }

    // getters & setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getServiceId() {
        return serviceId;
    }

    public void setServiceId(UUID serviceId) {
        this.serviceId = serviceId;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }
}
