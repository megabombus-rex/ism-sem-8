package jczech.pwr.ism.ism_lab02.entities.photos;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "photo_urls")
public class PhotoUrls {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID id;

    @Column(name = "photo_url")
    public String photoUrl;
}
