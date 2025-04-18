package jczech.pwr.ism.ism_lab02.services;

public interface AuthorizationService {
    public Long GetUserByEmail(String email, String password, String role);
}
