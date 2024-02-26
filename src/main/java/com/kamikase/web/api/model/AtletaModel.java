package com.kamikase.web.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import com.kamikase.web.api.validator.EmailValidation;

import java.io.Serializable;

@Getter
@Setter
@Entity
public class AtletaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 150)
    @NotEmpty(message = "O nome não pode ser nulo nem em branco")
    private String nome;
    private Integer anoNascimento;
    private String esporte;
    @Email
    @EmailValidation
    private String email;
    @CPF
    private String cpf;

}
