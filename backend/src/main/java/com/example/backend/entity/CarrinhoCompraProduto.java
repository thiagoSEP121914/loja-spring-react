package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "carrinhoCompraProduto")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarrinhoCompraProduto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrinhoCompraProduto;
    private Double valor;
    private Integer qtd;
    private String observacao;
    @ManyToOne
    @JoinColumn(name = "idProduto")
    private Produto produto;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}
