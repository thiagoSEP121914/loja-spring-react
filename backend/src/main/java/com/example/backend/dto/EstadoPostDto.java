package com.example.backend.dto;

import jakarta.annotation.Nonnull;

public record EstadoPostDto(@Nonnull String nome, @Nonnull String sigla) {
}
