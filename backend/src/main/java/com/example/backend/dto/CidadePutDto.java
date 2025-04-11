package com.example.backend.dto;

import jakarta.annotation.Nonnull;

public record CidadePutDto(@Nonnull Long id ,@Nonnull String nome, @Nonnull Long idEstado) {
}
