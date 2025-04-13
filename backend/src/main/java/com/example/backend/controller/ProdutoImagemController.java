package com.example.backend.controller;


import com.example.backend.entity.ProdutoImagem;
import com.example.backend.service.ProdutoimagemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/produtoImagem")
@RequiredArgsConstructor
public class ProdutoImagemController {

    private final ProdutoimagemService service;

    @GetMapping
    public ResponseEntity<List<ProdutoImagem>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoImagem> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/{idProduto}/imagens")
    public ResponseEntity<ProdutoImagem> insert(@PathVariable Long idProduto, @RequestParam MultipartFile multipartFile) {
        return new ResponseEntity<>(service.insert(idProduto,multipartFile), HttpStatus.CREATED);
    }

}
