package com.example.backend.dto;

import jakarta.annotation.Nonnull;

public record EstadoPutDto(@Nonnull Long id, @Nonnull String nome, @Nonnull String sigla) {
}
