package com.kamikase.web.api.dto;

import org.hibernate.validator.constraints.br.CPF;

import com.kamikase.web.api.validator.EmailValidation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AtletaDTO {

    private Integer id;

    @NotEmpty(message = "O nome não pode ser nulo nem em branco")
    private String nome;

    @NotEmpty(message = "O ano de nascimento não pode ser nulo nem em branco")
    private Integer anoNascimento;

    @NotEmpty(message = "O esporte não pode ser nulo nem em branco")
    private String esporte;

    @NotEmpty(message = "O email não pode ser nulo nem em branco")
    @Email
    @EmailValidation
    private String email;

    @NotEmpty(message = "O CPF não pode ser nulo nem em branco")
    @CPF
    private String cpf;
  
}
