package com.example.backend.repository;
import com.example.backend.entity.CarrinhoCompra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoCompraRepository extends JpaRepository<CarrinhoCompra, Long> {
}
