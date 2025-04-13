package com.example.backend.service;

import com.example.backend.dto.CarrinhoCompraPostDto;
import com.example.backend.dto.CarrinhoCompraPutDto;
import com.example.backend.entity.CarrinhoCompra;
import com.example.backend.entity.CarrinhoCompraProduto;
import com.example.backend.entity.Pessoa;
import com.example.backend.repository.CarrinhoCompraProdutoRepository;
import com.example.backend.repository.CarrinhoCompraRepository;
import com.example.backend.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarrinhoCompraService {

    private final CarrinhoCompraRepository repository;
    private final PessoaRepository pessoaRepository;
    private final CarrinhoCompraProdutoRepository carrinhoCompraProdutoRepository;

    public List<CarrinhoCompra> findAll() {
        return repository.findAll();
    }
    public CarrinhoCompra findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(": " + id + "NÃO EXISTE"));
    }

    public CarrinhoCompra insert (CarrinhoCompraPostDto carrinhoCompraPostDto) {
        CarrinhoCompra carrinhoCompra = new CarrinhoCompra();
        Pessoa pessoa = pessoaRepository.findById(carrinhoCompraPostDto.idPessoa())
                .orElseThrow(() -> new IllegalArgumentException(": " + carrinhoCompraPostDto.idPessoa() + "Não existe"));
        CarrinhoCompraProduto carrinhoCompraProduto = carrinhoCompraProdutoRepository.findById(carrinhoCompraPostDto.idCarrinhoCompraProduto())
                .orElseThrow(() -> new IllegalArgumentException(": " + carrinhoCompraPostDto.idCarrinhoCompraProduto() + "NÃO EXDISTE"));
        carrinhoCompra.setDataCompra(carrinhoCompraPostDto.dataCompra());
        carrinhoCompra.setObservacao(carrinhoCompraPostDto.observacao());
        carrinhoCompra.setSituacao(carrinhoCompraPostDto.situacao());
        carrinhoCompra.setDataCriacao(carrinhoCompraPostDto.dataCriacao());
        carrinhoCompra.setDataAtualizacao(carrinhoCompraPostDto.dataAtualizacao());
        carrinhoCompra.setPessoa(pessoa);
        carrinhoCompra.setCarrinhoCompraProduto(carrinhoCompraProduto);
        return repository.save(carrinhoCompra);
    }

    public CarrinhoCompra update(CarrinhoCompraPutDto carrinhoCompraPutDto) {
        CarrinhoCompra carrinhoCompra = this.findById(carrinhoCompraPutDto.id());
        Pessoa pessoa = pessoaRepository.findById(carrinhoCompraPutDto.idPessoa())
                .orElseThrow(() -> new IllegalArgumentException(": " + carrinhoCompraPutDto.idPessoa() + "Não existe"));
        CarrinhoCompraProduto carrinhoCompraProduto = carrinhoCompraProdutoRepository.findById(carrinhoCompraPutDto.idCarrinhoCompraProduto())
                .orElseThrow(() -> new IllegalArgumentException(": " + carrinhoCompraPutDto.idCarrinhoCompraProduto() + "NÃO EXDISTE"));
        carrinhoCompra.setObservacao(carrinhoCompraPutDto.observacao());
        carrinhoCompra.setSituacao(carrinhoCompraPutDto.situacao());
        carrinhoCompra.setDataAtualizacao(carrinhoCompraPutDto.dataAtualizacao());
        carrinhoCompra.setPessoa(pessoa);
        carrinhoCompra.setCarrinhoCompraProduto(carrinhoCompraProduto);
        return repository.save(carrinhoCompra);
    }

    public void delete(Long id) {
        CarrinhoCompra carrinhoCompra = this.findById(id);
        repository.deleteById(carrinhoCompra.getIdCarrinho());
    }
}
