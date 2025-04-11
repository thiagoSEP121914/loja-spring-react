package com.example.backend.entity;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CarrinhoCompras")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarrinhoCompra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrinho;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCompra;
    private String observacao;
    private String situacao;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @CreationTimestamp
    @Timestamp
    private Date dataAtualizacao;
    @ManyToOne
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoa;
    @ManyToOne
    @JoinColumn(name = "idCarrinhoProduto")
    private CarrinhoCompraProduto carrinhoCompraProduto;

}
