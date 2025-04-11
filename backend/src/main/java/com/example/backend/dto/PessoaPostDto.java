package com.example.backend.dto;

import com.example.backend.entity.Cidade;
import jakarta.annotation.Nonnull;

public record PessoaPostDto(@Nonnull String nome, @Nonnull String cpf, @Nonnull String senha, @Nonnull String endereco, @Nonnull String cep, @Nonnull
                            Long iDcidade) {
}
