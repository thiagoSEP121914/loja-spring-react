package com.example.backend.service;

import com.example.backend.dto.PessoaPostDto;
import com.example.backend.dto.PessoaPutDto;
import com.example.backend.entity.Cidade;
import com.example.backend.entity.Pessoa;
import com.example.backend.repository.CidadeRepository;
import com.example.backend.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository repository;
    private final CidadeRepository cidadeRepository;
    public List<Pessoa> findAll() {
        return repository.findAll();
    }

    public Pessoa findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("O id dever ser maior que zero"));
    }
    public Pessoa insert(PessoaPostDto pessoaPostDto) {
        Pessoa pessoa = new Pessoa();
        Cidade cidade = cidadeRepository.findById(pessoaPostDto.iDcidade())
                .orElseThrow(() -> new IllegalArgumentException("O estado nao existe!"));
        pessoa.setNome(pessoaPostDto.nome());
        pessoa.setCpf(pessoaPostDto.cpf());
        pessoa.setSenha(pessoaPostDto.senha());
        pessoa.setEndereco(pessoaPostDto.endereco());
        pessoa.setCep(pessoaPostDto.cep());
        pessoa.setCidade(cidade);
        return repository.save(pessoa);
    }


    public Pessoa update(PessoaPutDto pessoaPutDto) {
        Pessoa existingPessoa = this.findById(pessoaPutDto.id());
        Cidade cidade = cidadeRepository.findById(pessoaPutDto.iDcidade())
                .orElseThrow(() -> new IllegalArgumentException("Não existe cidade com o id: " + pessoaPutDto.iDcidade()));
        existingPessoa.setNome(pessoaPutDto.nome());
        existingPessoa.setCpf(pessoaPutDto.cpf());
        existingPessoa.setSenha(pessoaPutDto.senha());
        existingPessoa.setEndereco(pessoaPutDto.endereco());
        existingPessoa.setCep(pessoaPutDto.cep());
        existingPessoa.setCidade(cidade);
        return repository.save(existingPessoa);
    }
    public void deletePessoa (Long id) {
        Pessoa pessoa = this.findById(id);
        cidadeRepository.deleteById(pessoa.getIdPessoa());
    }
}
