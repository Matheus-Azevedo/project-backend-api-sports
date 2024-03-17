package com.kamikase.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kamikase.web.api.client.ClubeClient;
import com.kamikase.web.api.dto.ClubeDTO;
import com.kamikase.web.api.service.ClubeService;

@RestController
@RequestMapping("/clube")
public class ClubeController {

  @Autowired
  private ClubeService service;

  @Autowired
  private ClubeClient clubeClient;

  @PostMapping("/cadastrar")
  public ResponseEntity<ClubeDTO> cadastrar(@RequestBody ClubeDTO clube){
    clube = service.cadastrar(clube);
    return ResponseEntity.ok(clube);
  }

  @PutMapping("/alterar")
  public ResponseEntity<ClubeDTO> alterar(@RequestBody ClubeDTO clube){
    clube = service.alterar(clube);
    return ResponseEntity.ok(clube);
  }

  @DeleteMapping("/deletar/{id}")
  public ResponseEntity<Void> deletar(@PathVariable Integer id){
    service.deletar(id);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/buscar/{id}")
  public ResponseEntity<ClubeDTO> consultarPorId(@PathVariable Integer id){
    return ResponseEntity.ok(service.consultarPorId(id));
  }

  @GetMapping("/buscar/todos")
  public ResponseEntity<List<ClubeDTO>> listarTodos(){
    return ResponseEntity.ok(service.listar());
  }

  @GetMapping("/buscar/nome/{nome}")
  public ResponseEntity<List<ClubeDTO>> listarPorNome(@PathVariable String nome){
    return ResponseEntity.ok(service.listarPorNome(nome));
  }

  // Consulta externa

  @GetMapping("/clube/{id}")
  public ResponseEntity<ClubeDTO> consultarClube(@PathVariable Integer id){
    
    var clubeResponse = clubeClient.consultaClube(id);

    return ResponseEntity.ok(clubeResponse);
  }
}
