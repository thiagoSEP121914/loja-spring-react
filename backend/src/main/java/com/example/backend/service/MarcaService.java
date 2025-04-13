package com.example.backend.service;

import com.example.backend.dto.MarcaPostDto;
import com.example.backend.dto.MarcaPutDto;
import com.example.backend.entity.Marca;
import com.example.backend.repository.MarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MarcaService {

    private final MarcaRepository repository;

    public List<Marca> findAll () {
        return repository.findAll();
    }


    public Marca findById(Long id) {
        return  repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(": "  + id + ",Nao encontrado"));
    }

    public Marca insert(MarcaPostDto marcaPostDto) {
        Marca marca = new Marca();
        marca.setNome(marcaPostDto.nome());
        return repository.save(marca);
    }

    public Marca update (MarcaPutDto marcaPutDto) {
        Marca marca = this.findById(marcaPutDto.id());
        marca.setNome(marcaPutDto.nome());
        marca.setDataAtualizacao(new Date());
        return repository.save(marca);
    }

    public void delete (Long id) {
        Marca marca = this.findById(id);
        repository.delete(marca);
    }
}
