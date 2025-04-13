package com.example.backend.dto;

import com.example.backend.entity.PermissaoPessoa;
import jakarta.annotation.Nonnull;

import java.util.List;

public record PessoaPostDto(@Nonnull String nome,
                            @Nonnull String cpf,
                            @Nonnull String senha,
                            @Nonnull String endereco,
                            @Nonnull String cep,
                            @Nonnull
                            Long iDcidade,
                            @Nonnull List<PermissaoPessoa> permissaoPessoa) {
}
