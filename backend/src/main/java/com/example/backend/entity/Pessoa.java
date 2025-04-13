package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Pessoas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoa;
    private String nome;
    private String cpf;
    private String senha;
    private String endereco;
    private String cep;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFinalizacao;
    @ManyToOne
    @JoinColumn(name = "idCidade")
    private Cidade cidade;

    @OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Setter(value = AccessLevel.NONE)
    private List<PermissaoPessoa> permissaoPessoas;

    public void setPermissaoPessoas(List<PermissaoPessoa> permissaoPessoaList) {
        for (PermissaoPessoa p: permissaoPessoaList) {
            p.setPessoa(this);
        }
        this.permissaoPessoas = permissaoPessoaList;
    }
}
