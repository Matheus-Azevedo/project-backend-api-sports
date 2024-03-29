package com.kamikase.web.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kamikase.web.api.model.AtletaModel;

import java.util.List;

@Repository
public interface AtletaRepository
        extends JpaRepository<AtletaModel, Integer> {

    public List<AtletaModel> findByNomeOrderByNomeAsc(String nome);

    @Query(value = "select a from Atleta a where a.nome=:nome order by a.nome asc")
    public List<AtletaModel> buscarNomeAtleta(@Param("nome") String nome);

}
