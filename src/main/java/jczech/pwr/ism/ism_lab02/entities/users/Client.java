package jczech.pwr.ism.ism_lab02.entities.users;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID id;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    @Column(name = "email_address")
    public String emailAddress;

    @Column(name = "password_hash")
    public String passwordHash;

    @Column(name = "role_id")
    public UUID roleId;
}
