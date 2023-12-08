package com.votacao.desafio.api.domain.service;


import com.votacao.desafio.api.domain.entities.Pauta;
import com.votacao.desafio.api.domain.entities.Voto;
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
    	Optional<Pauta> pauta = Optional.empty();
    	pauta = pautaRepository.findById(pautaId);
    	if ( pauta.isPresent() ) {
    		return pauta.get();
    	} else {
    		return null;
    	}
    }

    public String resultadoVotos(Long pautaId) {
        Pauta pauta = pautaRepository.findById(pautaId)
                .orElseThrow(() -> new IllegalArgumentException("Pauta não encontrada"));
        
        int votosFavor = this.contarVotosFavor( pauta.getVotos());
        int votosContra = this.contarVotosContra( pauta.getVotos());
        
        if (votosFavor > votosContra) {
            return "Aprovação da Pauta";
        } else if (votosContra > votosFavor) {
            return "Rejeição da Pauta";
        } else {
            return "Empate";
        }

    }
    
    public int contarVotosFavor(List<Voto> votos) {
        return (int) votos.stream().filter(Voto::getVoto).count();
    }

    public int contarVotosContra(List<Voto> votos) {
        return (int) votos.stream().filter(v -> !v.getVoto()).count();
    }
    
}
