package com.votacao.desafio.api.domain.repository;

import com.votacao.desafio.api.domain.entities.Associado;
import com.votacao.desafio.api.domain.entities.Pauta;
import com.votacao.desafio.api.domain.entities.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {

      boolean existsByAssociadoAndPauta(Associado associado, Pauta pauta);
}
