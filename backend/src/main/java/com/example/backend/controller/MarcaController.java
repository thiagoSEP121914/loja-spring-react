package com.example.backend.controller;

import com.example.backend.dto.MarcaPostDto;
import com.example.backend.dto.MarcaPutDto;
import com.example.backend.entity.Marca;
import com.example.backend.service.MarcaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marca")
@RequiredArgsConstructor
public class MarcaController {

    private final MarcaService service;

    @GetMapping
    public ResponseEntity<List<Marca>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Marca> insert(@RequestBody MarcaPostDto marcaPostDto) {
        return new ResponseEntity<>(service.insert(marcaPostDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Marca> update(@RequestBody MarcaPutDto marcaPutDto) {
        return new ResponseEntity<>(service.update(marcaPutDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
