package com.example.backend.dto;

import lombok.NonNull;

public record MarcaPutDto(@NonNull Long id , @NonNull String nome) {
}
