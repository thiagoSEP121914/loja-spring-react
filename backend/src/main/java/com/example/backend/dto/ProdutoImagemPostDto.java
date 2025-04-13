package com.example.backend.dto;

import lombok.NonNull;

public record ProdutoImagemPostDto(@NonNull String nome, @NonNull Long idProduto) {
}
