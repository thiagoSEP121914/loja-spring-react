package com.example.backend.controller;

import com.example.backend.dto.CidadePostDto;
import com.example.backend.dto.CidadePutDto;
import com.example.backend.entity.Cidade;
import com.example.backend.service.CidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
@RequiredArgsConstructor
public class CidadeController {

    private final CidadeService service;

    @GetMapping
    public ResponseEntity<List<Cidade>> findaAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Cidade> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cidade> insert(@RequestBody CidadePostDto cidadePostDto) {
        return new ResponseEntity<>(service.insert(cidadePostDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Cidade> update(@RequestBody CidadePutDto cidadePutDto) {
        return new ResponseEntity<>(service.update(cidadePutDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
