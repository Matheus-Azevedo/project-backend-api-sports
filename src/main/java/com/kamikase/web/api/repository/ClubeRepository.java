package com.kamikase.web.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kamikase.web.api.dto.ClubeDTO;

public interface ClubeRepository extends JpaRepository<ClubeDTO, Integer> {

    public List<ClubeDTO> findByNomeOrderByNomeAsc(String nome);
  
}
