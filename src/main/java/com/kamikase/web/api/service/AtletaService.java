package com.kamikase.web.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kamikase.web.api.dto.AtletaDTO;
import com.kamikase.web.api.repository.AtletaRepository;

import java.util.List;
import java.util.Objects;

@Service
public class AtletaService {

    @Autowired
    private AtletaRepository repository;

    @SuppressWarnings("null")
    public AtletaDTO cadastrar(AtletaDTO atleta){
        return repository.save(atleta);
    }

    public List<AtletaDTO> listar(){
        return repository.findAll();
    }

    public List<AtletaDTO> listarPorNome(String nome){
        return repository.findByNomeOrderByNomeAsc(nome);
    }

    public AtletaDTO alterar(AtletaDTO atleta){
        if(Objects.isNull(atleta.getId())){
            throw new RuntimeException();
        }
        return repository.save(atleta);
    }

    @SuppressWarnings("null")
    public void deletar(Integer id){
        repository.deleteById(id);
    }

    @SuppressWarnings("null")
    public AtletaDTO consultarPorId(Integer id){
        return repository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

}
