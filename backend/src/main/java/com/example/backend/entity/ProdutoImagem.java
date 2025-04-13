package com.example.backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "produto_imagens")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutoImagem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
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
