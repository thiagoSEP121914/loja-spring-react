package com.example.backend.repository;

import com.example.backend.entity.Permisao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissaoRepository extends JpaRepository<Permisao, Long> {
}
