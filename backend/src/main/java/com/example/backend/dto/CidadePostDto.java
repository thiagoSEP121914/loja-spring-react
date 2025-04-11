package com.example.backend.dto;

import com.example.backend.entity.Estado;
import jakarta.annotation.Nonnull;

public record CidadePostDto(@Nonnull String nome, @Nonnull Long idEstado) {
}
