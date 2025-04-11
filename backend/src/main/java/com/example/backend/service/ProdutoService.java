package com.example.backend.service;

import com.example.backend.dto.ProdutoPostDto;
import com.example.backend.dto.ProdutoPutDto;
import com.example.backend.entity.Categoria;
import com.example.backend.entity.Marca;
import com.example.backend.entity.Produto;
import com.example.backend.repository.CategoriaRepository;
import com.example.backend.repository.MarcaRepository;
import com.example.backend.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;
    private final MarcaRepository marcaRepository;
    private final CategoriaRepository categoriaRepository;

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Produto findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("O id deve ser mair que zero"));
    }
    public Produto insert(ProdutoPostDto produtoPostDto) {
        Produto produto = new Produto();
        Marca marca = marcaRepository.findById(produtoPostDto.idMarca())
                .orElseThrow(() -> new IllegalArgumentException("O id: " +produtoPostDto.idMarca() + " Não foi encontrado"));
        Categoria categoria = categoriaRepository.findById(produtoPostDto.idCategoria())
                .orElseThrow(() -> new IllegalArgumentException("O id " + produtoPostDto.idCategoria() + "Não foi encontrado"));
        produto.setDescricaoCurta(produtoPostDto.descricaoCurta());
        produto.setDescricaoDetalhada(produtoPostDto.descricaoDetalhada());
        produto.setValorCusto(produtoPostDto.valorCusto());
        produto.setValorVenda(produtoPostDto.valorVenda());
        produto.setMarca(marca);
        produto.setCategoria(categoria);
        return repository.save(produto);
    }

    public Produto update (ProdutoPutDto produtoPutDto) {
        Produto produto = this.findById(produtoPutDto.idProduto());
        Marca marca = marcaRepository.findById(produtoPutDto.idMarca())
                .orElseThrow(() -> new IllegalArgumentException(": " + produtoPutDto.idMarca() + "id de marca não encontrado"));
        Categoria categoria = categoriaRepository.findById(produtoPutDto.idCategoria())
                .orElseThrow(() -> new IllegalArgumentException(": " + produtoPutDto.idCategoria() + "id de categoria nao encontrado"));

        produto.setDescricaoCurta(produtoPutDto.descricaoCurta());
        produto.setDescricaoDetalhada(produtoPutDto.descricaoDetalhada());
        produto.setValorCusto(produtoPutDto.valorCusto());
        produto.setValorVenda(produtoPutDto.valorVenda());
        produto.setMarca(marca);
        produto.setCategoria(categoria);
        produto.setDataAtualizacao(new Date());
        return repository.save(produto);
    }

    public void delete (Long id) {
        Produto produto = this.findById(id);
        repository.deleteById(produto.getIdProduto());
    }

}
