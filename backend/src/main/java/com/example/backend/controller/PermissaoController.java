package com.example.backend.controller;

import com.example.backend.dto.PermissaoPostDto;
import com.example.backend.dto.PermissaoPutDto;
import com.example.backend.entity.Permisao;
import com.example.backend.service.PermissaoService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissao")
@RequiredArgsConstructor
public class PermissaoController {

    private final PermissaoService service;

    @GetMapping
    public ResponseEntity<List<Permisao>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permisao> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Permisao> insert(@RequestBody PermissaoPostDto permissaoPostDto) {
       return new ResponseEntity<>(service.insert(permissaoPostDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Permisao> update(@RequestBody PermissaoPutDto permissaoPutDto) {
        return new ResponseEntity<>(service.update(permissaoPutDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
