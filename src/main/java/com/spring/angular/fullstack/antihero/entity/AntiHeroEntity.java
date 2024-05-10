package com.spring.angular.fullstack.antihero.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import java.util.UUID;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class AntiHeroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column(nullable = false,updatable = false)
    private UUID id;

    @NotNull(message = "firstName cannot be null")
    private String firstName;

    private String lastName;

    private String house;

    private String knownAs;

    @CreatedDate
    private String createdAt;
}
