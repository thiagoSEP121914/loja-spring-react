package com.example.backend.service;

import com.example.backend.dto.CarrinhoCompraProdutoPostDto;
import com.example.backend.dto.CarrinhoCompraProdutoPutDto;
import com.example.backend.dto.CarrinhoCompraPutDto;
import com.example.backend.entity.CarrinhoCompraProduto;
import com.example.backend.entity.Produto;
import com.example.backend.repository.CarrinhoCompraProdutoRepository;
import com.example.backend.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarrinhoCompraProdutoService {

    private final CarrinhoCompraProdutoRepository repository;

    private final ProdutoRepository produtoRepository;

    public List<CarrinhoCompraProduto> findAll() {
        return repository.findAll();
    }

    public CarrinhoCompraProduto findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(": " + id + "O nao existe "));
    }

    public CarrinhoCompraProduto insert(CarrinhoCompraProdutoPostDto carrinhoCompraProdutoPostDto) {
        CarrinhoCompraProduto carrinhoCompraProduto = new CarrinhoCompraProduto();
        Produto produto = produtoRepository.findById(carrinhoCompraProdutoPostDto.idProduto())
                .orElseThrow(() -> new IllegalArgumentException(": " + carrinhoCompraProdutoPostDto.idProduto()  + "Nao existe"));

        carrinhoCompraProduto.setValor(carrinhoCompraProdutoPostDto.valor());
        carrinhoCompraProduto.setQtd(carrinhoCompraProdutoPostDto.qtd());
        carrinhoCompraProduto.setObservacao(carrinhoCompraProduto.getObservacao());
        carrinhoCompraProduto.setProduto(produto);
        return repository.save(carrinhoCompraProduto);
    }

    public CarrinhoCompraProduto update(CarrinhoCompraProdutoPutDto carrinhoCompraProdutoPutDto) {
        CarrinhoCompraProduto carrinhoCompraProduto = new CarrinhoCompraProduto();
        Produto produto = produtoRepository.findById(carrinhoCompraProdutoPutDto.id())
                .orElseThrow(() -> new IllegalArgumentException("Id: " + carrinhoCompraProdutoPutDto + "NÃO EXISTE"));
        carrinhoCompraProduto.setValor(carrinhoCompraProdutoPutDto.valor());
        carrinhoCompraProduto.setQtd(carrinhoCompraProdutoPutDto.qtd());
        carrinhoCompraProduto.setObservacao(carrinhoCompraProdutoPutDto.observacao());
        carrinhoCompraProduto.setProduto(produto);
        carrinhoCompraProduto.setDataAtualizacao(new Date());
        return repository.save(carrinhoCompraProduto);
    }

    public void delete(Long id) {
        CarrinhoCompraProduto carrinhoCompraProduto = this.findById(id);
        repository.deleteById(carrinhoCompraProduto.getIdCarrinhoCompraProduto());
    }

}
