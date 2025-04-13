package com.example.backend.service;

import com.example.backend.entity.Produto;
import com.example.backend.entity.ProdutoImagem;
import com.example.backend.repository.ProdutoImagemRepository;
import com.example.backend.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProdutoimagemService {

    private final ProdutoImagemRepository repository;
    private final ProdutoRepository produtoRepository;

    public List<ProdutoImagem> findAll() {
        return repository.findAll();
    }

    public ProdutoImagem findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id nao encontrado"));
    }

    public ProdutoImagem insert (Long idProduto, MultipartFile file) {
        Produto produto = produtoRepository.findById(idProduto)
                .orElseThrow(() -> new IllegalArgumentException("Id NÃO ENCONTRADO"));
        String nomeImagem = saveImage(produto.getDescricaoCurta(), file);
        ProdutoImagem produtoImagem = new ProdutoImagem();
        produtoImagem.setName(nomeImagem);
        produtoImagem.setProduto(produto);
        return repository.save(produtoImagem);
    }

    public void delete(Long id) {
        ProdutoImagem produtoImagem = this.findById(id);
        repository.deleteById(produtoImagem.getId());
    }
    private String saveImage(String nomeProduto, MultipartFile file) {
        try {
            // Verifique se o arquivo tem nome
            String nomeArquivoOriginal = file.getOriginalFilename();
            if (nomeArquivoOriginal == null || nomeArquivoOriginal.isEmpty()) {
                throw new IllegalArgumentException("Nome do arquivo inválido");
            }

            // Verifique se a extensão existe no nome do arquivo
            String extensao = "";
            int extIndex = nomeArquivoOriginal.lastIndexOf(".");
            if (extIndex != -1) {
                extensao = nomeArquivoOriginal.substring(extIndex);
            } else {
                throw new IllegalArgumentException("Arquivo sem extensão");
            }

            // Sanitiza o nome do produto (remove caracteres inválidos)
            String nomeSanitizado = nomeProduto
                    .replaceAll("[\\\\/:*?\"<>|]", "") // remove caracteres inválidos
                    .replaceAll("\\s+", "_");         // troca espaços por underline

            // Gere o nome final do arquivo
            String nomeArquivo = UUID.randomUUID() + "_" + nomeSanitizado + extensao;

            // Salva o arquivo
            String pastaDestino = "D:/projeto_workspace/loja_virtual/backend/uploads/";
            Path caminho = Paths.get(pastaDestino + nomeArquivo);
            Files.write(caminho, file.getBytes());

            return nomeArquivo;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar a imagem: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Erro no nome do arquivo: " + e.getMessage());
        }
    }
}
