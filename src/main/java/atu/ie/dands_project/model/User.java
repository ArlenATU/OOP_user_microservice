package atu.ie.dands_project.model;

// Importing JPA annotations to map this class to a database table
import jakarta.persistence.*;

// Importing LocalDateTime to store date and time
import java.time.LocalDateTime;

@Entity

@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public User() {
    }

    // ===== GETTERS =====
    // Getters allow other classes to read private fields.

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // ===== SETTERS =====
    // Setters allow other classes to modify private fields.

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}