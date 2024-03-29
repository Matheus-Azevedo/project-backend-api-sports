package com.kamikase.web.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kamikase.web.api.model.ClubeModel;

public interface ClubeRepository extends JpaRepository<ClubeModel, Integer> {

    public List<ClubeModel> findByNomeOrderByNomeAsc(String nome);

    public List<ClubeModel> findByNome(String nome);
  
}
