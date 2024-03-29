package com.kamikase.web.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "clube")
public class ClubeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String nome_popular;

    @Column(length = 100)
    private String sigla;

    @Column(length = 100)
    private String escudo;

    @Column(length = 100)
    private String nome;

    @Column(length = 100)
    private String apelido;
  
}
