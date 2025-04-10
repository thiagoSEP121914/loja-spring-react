package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Cidades")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCidade;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "idEstado")
    private Estado estado;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

}
