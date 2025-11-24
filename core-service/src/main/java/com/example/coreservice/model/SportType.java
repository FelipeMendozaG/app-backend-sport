package com.example.coreservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="sport_types")
@Getter
@Setter
public class SportType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String name;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name="updated_at", updatable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "sportType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Field> fields = new ArrayList<>();
}
