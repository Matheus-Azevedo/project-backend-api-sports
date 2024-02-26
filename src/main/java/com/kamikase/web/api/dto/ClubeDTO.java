package com.kamikase.web.api.dto;

import lombok.Data;

@Data
public class ClubeDTO {
  
    private Integer id;
    private String nome;
    private String estado;
    private String email;
    private String cnpj;
    private String dataCriacao;
}
