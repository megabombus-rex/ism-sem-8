package jczech.pwr.ism.ism_lab02.entities.users;

import java.util.UUID;

public class User {
    public UUID id;
    public String firstName;
    public String lastName;
    public String emailAddress;
    public String passwordHash;
    public UUID roleId;
}
