package com.kamikase.web.api.service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kamikase.web.api.dto.ClubeDTO;
import com.kamikase.web.api.model.ClubeModel;
import com.kamikase.web.api.repository.ClubeRepository;


@Service
public class ClubeService {

  @Autowired
  private ClubeRepository repository;

  @Autowired
  private ModelMapper modelMapper;

  @SuppressWarnings("null")
  public ClubeDTO cadastrar(ClubeDTO clube){
    ClubeModel clubeModel = modelMapper.map(clube, ClubeModel.class);
    return modelMapper.map(repository.save(clubeModel), ClubeDTO.class);
  }

  public ClubeDTO alterar(ClubeDTO clube){
    ClubeModel clubeModel = modelMapper.map(clube, ClubeModel.class);
    Objects.requireNonNull(clubeModel.getId());
    return modelMapper.map(repository.save(clubeModel), ClubeDTO.class);
  }

  @SuppressWarnings("null")
  public void deletar(Integer id){
    repository.deleteById(id);
  }

  @SuppressWarnings("null")
  public ClubeDTO consultarPorId(Integer id){
    return repository.findById(id).map(clube -> modelMapper.map(clube, ClubeDTO.class)).orElse(null);
  }

  public List<ClubeDTO> listar(){
    ClubeDTO clubeDTO = modelMapper.map(repository.findAll(), ClubeDTO.class);
    return Collections.singletonList(clubeDTO);
  }

  public List<ClubeDTO> listarPorNome(String nome){
    ClubeDTO clubeDTO = modelMapper.map(repository.findByNome(nome), ClubeDTO.class);
    return Collections.singletonList(clubeDTO);
  }
  
}
