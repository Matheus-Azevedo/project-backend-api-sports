package com.kamikase.web.api.model;

import jakarta.persistence.*;
import lombok.Data;


import java.io.Serializable;

@Data
@Entity
@Table(name = "atleta")
public class AtletaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String nome;

    @Column(length = 100)
    private Integer anoNascimento;
    
    @Column(length = 100)
    private String esporte;

    @Column(length = 100)
    private String email;

    @Column(length = 100)
    private String cpf;

}
