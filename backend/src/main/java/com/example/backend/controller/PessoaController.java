package com.example.backend.controller;

import com.example.backend.dto.PessoaPostDto;
import com.example.backend.dto.PessoaPutDto;
import com.example.backend.entity.Pessoa;
import com.example.backend.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService service;

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById (@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pessoa> insert(@RequestBody PessoaPostDto pessoaPostDto) {
        return new ResponseEntity<>(service.insert(pessoaPostDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Pessoa> update(@RequestBody PessoaPutDto pessoaPutDto) {
        return new ResponseEntity<>(service.update(pessoaPutDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deletePessoa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
