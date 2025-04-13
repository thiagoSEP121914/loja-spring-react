package com.example.backend.controller;

import com.example.backend.dto.CategoriaPostDto;
import com.example.backend.dto.CategoriaPuttDto;
import com.example.backend.entity.Categoria;
import com.example.backend.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService service;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Categoria> insert(@RequestBody CategoriaPostDto categoriaPostDto) {
        return new ResponseEntity<>(service.insert(categoriaPostDto), HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Categoria> update(@RequestBody CategoriaPuttDto categoriaPuttDto) {
        return new ResponseEntity<>(service.update(categoriaPuttDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
}
