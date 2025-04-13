package com.example.backend.controller;

import com.example.backend.dto.CarrinhoCompraPostDto;
import com.example.backend.dto.CarrinhoCompraPutDto;
import com.example.backend.entity.CarrinhoCompra;
import com.example.backend.service.CarrinhoCompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrinhoCompra")
@RequiredArgsConstructor
public class CarrinhoCompraController {

    private final CarrinhoCompraService service;

    @GetMapping
    public ResponseEntity<List<CarrinhoCompra>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoCompra> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarrinhoCompra> insert(CarrinhoCompraPostDto carrinhoCompraPostDto) {
        return new ResponseEntity<>(service.insert(carrinhoCompraPostDto), HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<CarrinhoCompra> update(@RequestBody CarrinhoCompraPutDto carrinhoCompraPutDto) {
        return new ResponseEntity<>(service.update(carrinhoCompraPutDto), HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
