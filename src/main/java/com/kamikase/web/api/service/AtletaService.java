package com.kamikase.web.api.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kamikase.web.api.dto.AtletaDTO;
import com.kamikase.web.api.model.AtletaModel;
import com.kamikase.web.api.repository.AtletaRepository;

import java.util.List;
import java.util.Objects;

@Service
public class AtletaService {

    @Autowired
    private AtletaRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @SuppressWarnings("null")
    public AtletaDTO cadastrar(AtletaDTO atleta){
        AtletaModel model = modelMapper.map(atleta, AtletaModel.class);
        return modelMapper.map(repository.save(model), AtletaDTO.class);
    }

    public List<AtletaDTO> listar(){
        AtletaDTO atletaDTO = modelMapper.map(repository.findAll(), AtletaDTO.class);
        return List.of(atletaDTO);
    }

    public List<AtletaDTO> listarPorNome(String nome){
        AtletaDTO atletaDTO = modelMapper.map(repository.findByNomeOrderByNomeAsc(nome), AtletaDTO.class);
        return List.of(atletaDTO);
    }

    public AtletaDTO alterar(AtletaDTO atleta){
        AtletaModel model = modelMapper.map(atleta, AtletaModel.class);
        Objects.requireNonNull(model.getId());
        return modelMapper.map(repository.save(model), AtletaDTO.class);
    }

    @SuppressWarnings("null")
    public void deletar(Integer id){
        repository.deleteById(id);
    }

    @SuppressWarnings("null")
    public AtletaDTO consultarPorId(Integer id){
        return repository.findById(id).map(atleta -> modelMapper.map(atleta, AtletaDTO.class)).orElse(null);
    }

}
