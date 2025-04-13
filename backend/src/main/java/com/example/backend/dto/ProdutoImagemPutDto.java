package com.example.backend.dto;

import lombok.NonNull;

public record ProdutoImagemPutDto(@NonNull Long id, @NonNull String nome, @NonNull Long idProduto) {
}
