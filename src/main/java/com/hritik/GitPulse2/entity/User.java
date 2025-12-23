package com.hritik.GitPulse2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String githubUsername;

    @Column(nullable = false)
    private Boolean active = true;

    @Column(name = "last_event_id")
    private String lastEventId;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    /**
     * Default constructor.
     */
    public User() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * Parameterized constructor.
     *
     * @param email          User's email address
     * @param githubUsername GitHub username to track
     */
    public User(String email, String githubUsername) {
        this();
        this.email = email;
        this.githubUsername = githubUsername;
    }


    @Override
    public String toString() {
        return "User {" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", githubUsername='" + githubUsername + '\'' +
                ", active=" + active +
                '}';
    }
}
