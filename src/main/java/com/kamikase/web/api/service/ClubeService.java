package com.kamikase.web.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kamikase.web.api.dto.ClubeDTO;
import com.kamikase.web.api.repository.ClubeRepository;


@Service
public class ClubeService {

  @Autowired
  private ClubeRepository repository;

  @SuppressWarnings("null")
  public ClubeDTO cadastrar(ClubeDTO clube){
    return repository.save(clube);
  }

  public ClubeDTO alterar(ClubeDTO clube){
    if(clube.getId() == null){
      throw new RuntimeException();
    }
    return repository.save(clube);
  }

  @SuppressWarnings("null")
  public void deletar(Integer id){
    repository.deleteById(id);
  }

  @SuppressWarnings("null")
  public ClubeDTO consultarPorId(Integer id){
    return repository.findById(id)
            .orElseThrow(RuntimeException::new);
  }

  public List<ClubeDTO> listar(){
    return repository.findAll();
  }

  public List<ClubeDTO> listarPorNome(String nome){
    return repository.findByNomeOrderByNomeAsc(nome);
  }
  
}
