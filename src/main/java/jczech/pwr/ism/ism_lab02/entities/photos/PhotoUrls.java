package jczech.pwr.ism.ism_lab02.entities.photos;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "photo_urls")
public class PhotoUrls {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public UUID id;

    @Column(name = "photo_url")
    public String photoUrl;

    // constructors
    public PhotoUrls() { }

    public PhotoUrls(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    // getters & setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
