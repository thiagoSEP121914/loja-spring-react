package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Permissões")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Permisao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPermissao;
    private String nome;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}
