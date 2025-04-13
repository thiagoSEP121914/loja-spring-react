package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "categorias")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;
    private String nome;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}
