package com.kamikase.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kamikase.web.api.client.ViaCepClient;
import com.kamikase.web.api.dto.AtletaModel;
import com.kamikase.web.api.dto.CepResponseDTO;
import com.kamikase.web.api.service.AtletaService;

import java.util.List;


@RestController
@RequestMapping("/atleta")
public class AtletaController {
    @Autowired
    private AtletaService service;

    @Autowired
    private ViaCepClient viaCepClient;

    @PostMapping("/cadastrar")
    public ResponseEntity<AtletaModel> cadastrar(@RequestBody AtletaModel atleta){
        atleta = service.cadastrar(atleta);
        return ResponseEntity.ok(atleta);
    }

    @PutMapping("/alterar")
    public ResponseEntity<AtletaModel> alterar(@RequestBody AtletaModel atleta){
        atleta = service.alterar(atleta);
        return ResponseEntity.ok(atleta);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        service.deletar(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<AtletaModel> consultarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(service.consultarPorId(id));
    }

    @GetMapping("/buscar/todos")
    public ResponseEntity<List<AtletaModel>> listarTodos(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/buscar/nome/{nome}")
    public ResponseEntity<List<AtletaModel>> listarPorNome(@PathVariable String nome){
        return ResponseEntity.ok(service.listarPorNome(nome));
    }

    // Consulta externa


    @GetMapping("/cep/{cep}")
    public ResponseEntity<CepResponseDTO> consultarCepAtleta(@PathVariable String cep){

        var cepResponse = viaCepClient.consultaCep(cep);

        return ResponseEntity.ok(cepResponse);
    }



}
