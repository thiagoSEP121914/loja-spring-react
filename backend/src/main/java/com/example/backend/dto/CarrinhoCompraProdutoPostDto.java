package com.example.backend.dto;

import lombok.NonNull;

public record CarrinhoCompraProdutoPostDto(@NonNull Double valor, @NonNull Integer qtd, @NonNull String observacao, @NonNull Long idProduto) {
}
