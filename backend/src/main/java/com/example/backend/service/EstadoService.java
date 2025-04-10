package com.example.backend.service;

import com.example.backend.dto.EstadoPostDto;
import com.example.backend.dto.EstadoPutDto;
import com.example.backend.entity.Estado;
import com.example.backend.repository.EstadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public Estado insert (EstadoPostDto estadoPostDto) {
        Estado estado = new Estado();
        estado.setNome(estadoPostDto.nome());
        estado.setSigla(estadoPostDto.sigla());
        return repository.save(estado);
    }

    public void delete (long id) {
        if (id < 0) {
            throw new IllegalArgumentException("O id dever ser maior que zero");
        }
        repository.deleteById(id);
    }

    public Estado update (EstadoPutDto estado) {
        var existingEstado = this.findById(estado.id());
        existingEstado.setNome(estado.nome());
        existingEstado.setSigla(estado.sigla());
        existingEstado.setDataAtualizacao(new Date());
        return repository.save(existingEstado);
    }
}
