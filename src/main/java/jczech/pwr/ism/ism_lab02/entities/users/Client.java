package jczech.pwr.ism.ism_lab02.entities.users;

import jakarta.persistence.*;
import jczech.pwr.ism.ism_lab02.entities.businesses.gifts.Order;
import jczech.pwr.ism.ism_lab02.entities.businesses.gifts.ServiceSchedule;
import jczech.pwr.ism.ism_lab02.entities.clients.ClientPurchase;
import jczech.pwr.ism.ism_lab02.entities.clients.ShoppingCart;
import jczech.pwr.ism.ism_lab02.entities.reviews.Review;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Set<ClientPurchase> clientPurchases = new HashSet<>();

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Set<Review> reviews = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ShoppingCart shoppingCart;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Set<Order> orders = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ServiceSchedule serviceSchedule;

    // constructors
    public Client() { }

    public Client(String firstName, String lastName, String emailAddress, String passwordHash, UUID roleId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.passwordHash = passwordHash;
        this.roleId = roleId;
    }

    // getters & setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }
}
