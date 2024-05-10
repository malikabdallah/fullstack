package com.spring.angular.fullstack.antihero.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AntiHeroDTO {

    private UUID id;

    @NotNull(message = "firstName cannot be null")
    private String firstName;

    private String lastName;

    private String house;

    private String knownAs;
}
