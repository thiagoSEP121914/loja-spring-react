package com.example.backend.dto;

import com.example.backend.entity.CarrinhoCompraProduto;
import com.example.backend.entity.Pessoa;
import lombok.NonNull;

import java.util.Date;

public record CarrinhoCompraPostDto(@NonNull Date dataCompra, @NonNull String observacao, @NonNull String situacao, @NonNull Date dataCriacao, @NonNull Date dataAtualizacao, @NonNull
                                    Long idPessoa, @NonNull Long idCarrinhoCompraProduto) {
}
