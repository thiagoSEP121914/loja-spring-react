package com.example.backend.dto;

import lombok.NonNull;

import java.util.Date;

public record CarrinhoCompraPutDto(@NonNull Long id,@NonNull Date dataCompra, @NonNull String observacao, @NonNull String situacao, @NonNull Date dataCriacao, @NonNull Date dataAtualizacao, @NonNull
                                    Long idPessoa, @NonNull Long idCarrinhoCompraProduto) {
}
