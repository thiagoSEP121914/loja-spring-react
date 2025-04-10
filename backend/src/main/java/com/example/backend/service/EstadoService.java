package com.example.backend.service;

import com.example.backend.entity.Estado;
import com.example.backend.repository.EstadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstadoService {

    private final EstadoRepository repository;

    public List<Estado> findAll () {
        return repository.findAll();
    }

    public Estado findById (Long id) {
        return repository.findById(id).orElseThrow(()-> new IllegalArgumentException());
    }

}
