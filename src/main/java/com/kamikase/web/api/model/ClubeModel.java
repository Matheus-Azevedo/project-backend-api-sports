package com.kamikase.web.api.model;

import org.hibernate.validator.constraints.br.CNPJ;

import com.kamikase.web.api.validator.EmailValidation;
import com.kamikase.web.api.validator.NameValidation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "clube")
public class ClubeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @NotNull
    @NameValidation(message = "Nome inválido: tente um nome diferente de Flamengo, Palmeiras, Fluminense, Botafogo")
    private String nome;

    @NotEmpty
    @NotNull
    private String estado;

    @NotEmpty
    @NotNull
    @Email
    @EmailValidation
    private String email;

    @NotEmpty
    @NotNull
    @CNPJ
    private String cnpj;

    @NotEmpty
    @NotNull
    private String dataCriacao;
  
}
