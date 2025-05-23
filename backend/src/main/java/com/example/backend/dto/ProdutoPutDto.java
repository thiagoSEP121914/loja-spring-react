package com.example.backend.dto;

import com.example.backend.entity.Categoria;
import jakarta.annotation.Nonnull;

public record ProdutoPutDto(
        @Nonnull Long idProduto,
        @Nonnull String descricaoCurta,
        @Nonnull String descricaoDetalhada,
        @Nonnull Double valorCusto,
        @Nonnull Double valorVenda,
        @Nonnull Long idMarca, @Nonnull Long idCategoria) {
}
