package com.example.backend.controller;

import com.example.backend.dto.CarrinhoCompraProdutoPostDto;
import com.example.backend.dto.CarrinhoCompraProdutoPutDto;
import com.example.backend.entity.CarrinhoCompraProduto;
import com.example.backend.service.CarrinhoCompraProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrinhoProduto")
@RequiredArgsConstructor
public class CarrinhoCompraProdutoController {

    private final CarrinhoCompraProdutoService service;

    @GetMapping
    public ResponseEntity<List<CarrinhoCompraProduto>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoCompraProduto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarrinhoCompraProduto> insert (@PathVariable CarrinhoCompraProdutoPostDto carrinhoCompraProdutoPostDto) {
        return new ResponseEntity<>(service.insert(carrinhoCompraProdutoPostDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CarrinhoCompraProduto> update (@RequestBody CarrinhoCompraProdutoPutDto carrinhoCompraProdutoPutDto) {
        return new ResponseEntity<>(service.update(carrinhoCompraProdutoPutDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
