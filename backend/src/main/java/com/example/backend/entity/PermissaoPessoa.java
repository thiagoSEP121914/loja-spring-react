package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "permissao_pessoa")
@Data
public class PermissaoPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idPessoa")
    @JsonIgnore
    private Pessoa pessoa;
    @ManyToOne
    @JoinColumn(name = "idPermissao")
    private Permisao permisao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datacriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

}
