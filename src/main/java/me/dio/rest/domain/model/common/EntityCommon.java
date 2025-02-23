package me.dio.rest.domain.model.common;

import jakarta.persistence.*;

import java.time.Instant;

@MappedSuperclass
public abstract class EntityCommon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Long getId() {
        return id;
    }
}
