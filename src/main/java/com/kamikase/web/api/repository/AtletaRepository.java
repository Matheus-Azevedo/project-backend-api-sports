package com.kamikase.web.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kamikase.web.api.dto.AtletaDTO;

import java.util.List;

@Repository
public interface AtletaRepository
        extends JpaRepository<AtletaDTO, Integer> {

    public List<AtletaDTO> findByNomeOrderByNomeAsc(String nome);

    @Query(value = "select a from Atleta a where a.nome=:nome order by a.nome asc")
    public List<AtletaDTO> buscarNomeAtleta(@Param("nome") String nome);

}
