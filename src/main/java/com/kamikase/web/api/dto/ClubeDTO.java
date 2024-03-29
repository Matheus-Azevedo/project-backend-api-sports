package com.kamikase.web.api.dto;

import com.kamikase.web.api.validator.NameValidation;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClubeDTO {
  
    private Integer id;

    @NotEmpty
    @NotNull
    @NameValidation(message = "Nome inválido: tente um nome diferente de Flamengo, Palmeiras, Fluminense, Botafogo")
    private String nome_popular;

    @NotEmpty
    @NotNull
    private String sigla;

    @NotEmpty
    @NotNull
    private String escudo;

    @NotEmpty
    @NotNull
    private String nome;

    @NotEmpty
    @NotNull
    private String apelido;
}