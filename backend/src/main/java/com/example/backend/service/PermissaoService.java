package com.example.backend.service;

import com.example.backend.dto.PermissaoPostDto;
import com.example.backend.dto.PermissaoPutDto;
import com.example.backend.entity.Permisao;
import com.example.backend.repository.PermissaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissaoService  {

    private final PermissaoRepository repository;

    public List<Permisao> findAll() {
        return repository.findAll();
    }

    public Permisao findById(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("ID:" + id + "Não foi encontrado"));
    }

    public Permisao insert(PermissaoPostDto permisaoPostDto) {
        Permisao permisao = new Permisao();
        permisao.setNome(permisaoPostDto.nome());
        return repository.save(permisao);
    }

    public Permisao update(PermissaoPutDto permissaoPutDto) {
        Permisao permisao = this.findById(permissaoPutDto.id());
        permisao.setNome(permissaoPutDto.nome());
        permisao.setDataCriacao(new Date());
        return repository.save(permisao);
    }

    public void delete (Long id) {
        Permisao permisao = this.findById(id);
        repository.deleteById(permisao.getIdPermissao());
    }
}
