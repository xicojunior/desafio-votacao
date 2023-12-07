package com.votacao.desafio.api.domain.service;


import com.votacao.desafio.api.domain.entities.Pauta;
import com.votacao.desafio.api.domain.repository.PautaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PautaService {

    private final PautaRepository pautaRepository;

    @Autowired
    public PautaService(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    public Pauta salvar(Pauta pauta) {
        return pautaRepository.save(pauta);
    }

    public List<Pauta> listarTodas(){
    	List<Pauta> listaPautas = pautaRepository.findAll();
    	return listaPautas;
    }
    
    public Pauta listarPauta(Long pautaId){
    	Optional<Pauta> pautas = pautaRepository.findById(pautaId);
    	return pautas.get();
    }

    /*
    public String resultadoVotacao(Long pautaId) {
        Pauta pauta = pautaRepository.findById(pautaId)
                .orElseThrow(() -> new IllegalArgumentException("Pauta não encontrada"));
        return pauta.resultadoVotacao();
    }
    */
    
}
