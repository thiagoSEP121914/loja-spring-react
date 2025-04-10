package com.example.backend.controller;
import com.example.backend.dto.EstadoPostDto;
import com.example.backend.dto.EstadoPutDto;
import com.example.backend.entity.Estado;
import com.example.backend.service.EstadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estado")
@RequiredArgsConstructor
public class EstadoController {

    private final EstadoService service;

    @GetMapping
    public ResponseEntity<List<Estado>> findALL() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> findById(@PathVariable long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Estado> insert(@RequestBody EstadoPostDto estadoPostDto) {
        return new ResponseEntity<>(service.insert(estadoPostDto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Estado> update(@RequestBody EstadoPutDto estadoPutDto) {
        return new ResponseEntity<>(service.update(estadoPutDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
