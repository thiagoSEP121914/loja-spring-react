package com.example.backend.dto;

import lombok.NonNull;

public record CarrinhoCompraProdutoPutDto(@NonNull Long id ,@NonNull Double valor, @NonNull Integer qtd, @NonNull String observacao, @NonNull Long idProduto) {
}
