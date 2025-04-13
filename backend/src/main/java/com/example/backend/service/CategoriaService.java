package com.example.backend.service;

import com.example.backend.dto.CategoriaPostDto;
import com.example.backend.dto.CategoriaPuttDto;
import com.example.backend.entity.Categoria;
import com.example.backend.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository repository;

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria findById(Long id ) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(":" + id + "NÃO EXISTE!"));
    }


    public Categoria insert(CategoriaPostDto categoriaPostDto) {
        Categoria categoria = new Categoria();
        categoria.setNome(categoriaPostDto.nome());
        return repository.save(categoria);
    }

    public Categoria update(CategoriaPuttDto categoriaPuttDto) {
        Categoria categoria = this.findById(categoriaPuttDto.id());
        categoria.setNome(categoriaPuttDto.nome());
        categoria.setDataAtualizacao(new Date());
        return repository.save(categoria);
    }

    public void delete(Long id) {
        Categoria categoria = this.findById(id);
        repository.deleteById(categoria.getIdCategoria());
    }
}
