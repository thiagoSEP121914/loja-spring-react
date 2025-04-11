package com.example.backend.controller;

import com.example.backend.dto.ProdutoPostDto;
import com.example.backend.dto.ProdutoPutDto;
import com.example.backend.entity.Produto;
import com.example.backend.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Produto> insert(@RequestBody ProdutoPostDto produtoPostDto) {
        return new ResponseEntity<>(service.insert(produtoPostDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Produto> update(@RequestBody ProdutoPutDto produtoPutDto) {
        return new ResponseEntity<>(service.update(produtoPutDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
