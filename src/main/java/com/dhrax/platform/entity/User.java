package com.dhrax.platform.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false, length = 20)
    private String role; // ADMIN, USER

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /* ---------- Lifecycle Hook ---------- */

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
