package com.example.backend.repository;

import com.example.backend.entity.ProdutoImagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoImagemRepository extends JpaRepository<ProdutoImagem, Long> {
}
