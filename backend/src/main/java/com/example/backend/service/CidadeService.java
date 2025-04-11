package com.example.backend.service;

import com.example.backend.dto.CidadePostDto;
import com.example.backend.dto.CidadePutDto;
import com.example.backend.entity.Cidade;
import com.example.backend.entity.Estado;
import com.example.backend.repository.CidadeRepository;
import com.example.backend.repository.EstadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CidadeService {

    private final CidadeRepository repository;
    private final EstadoRepository estadoRepository;

    public List<Cidade> findAll () {
       return repository.findAll();
    }

    public Cidade findById (Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Cidade com o " + id + "Não encontrada"));
    }

    public Cidade insert(CidadePostDto cidadePostDto) {
        Cidade cidade = new Cidade();
        Estado estado = estadoRepository.findById(cidadePostDto.idEstado())
                .orElseThrow(()-> new IllegalArgumentException("Estado com o id: " + cidadePostDto.idEstado() + "Não encontrada!"));
        cidade.setNome(cidadePostDto.nome());
        cidade.setEstado(estado);
        return repository.save(cidade);
    }

    public void delete(Long id) {
        Cidade cidade = findById(id);
        repository.deleteById(cidade.getIdCidade());
    }

    public Cidade update(CidadePutDto cidadePutDto) {
        var existingCidade = this.findById(cidadePutDto.id());
        existingCidade.setNome(cidadePutDto.nome());
        existingCidade.setDataAtualizacao(new Date());
        return repository.save(existingCidade);
    }
}
