package com.kamikase.web.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kamikase.web.api.model.AtletaModel;
import com.kamikase.web.api.repository.AtletaRepository;

import java.util.List;
import java.util.Objects;

@Service
public class AtletaService {
    @Autowired
    private AtletaRepository repository;

    public AtletaModel cadastrar(AtletaModel atleta){
        return repository.save(atleta);
    }

    public List<AtletaModel> listar(){
        return repository.findAll();
    }

    public List<AtletaModel> listarPorNome(String nome){
        return repository.findByNomeOrderByNomeAsc(nome);
    }

    public AtletaModel alterar(AtletaModel atleta){
        if(Objects.isNull(atleta.getId())){
            throw new RuntimeException();
        }
        return repository.save(atleta);
    }

    public void deletar(Integer id){
        repository.deleteById(id);
    }

    public AtletaModel consultarPorId(Integer id){
        return repository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

}
