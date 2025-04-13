package com.example.backend.dto;

import jakarta.annotation.Nonnull;

public record PermissaoPutDto(@Nonnull Long id, @Nonnull String nome) {
}
