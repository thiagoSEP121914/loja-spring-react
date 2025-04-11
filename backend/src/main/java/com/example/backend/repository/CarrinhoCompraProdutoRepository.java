package com.example.backend.repository;

import com.example.backend.entity.CarrinhoCompra;
import com.example.backend.entity.CarrinhoCompraProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoCompraProdutoRepository extends JpaRepository<CarrinhoCompraProduto, Long> {
}
