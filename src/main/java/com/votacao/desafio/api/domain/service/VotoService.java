
package com.votacao.desafio.api.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.votacao.desafio.api.domain.entities.Associado;
import com.votacao.desafio.api.domain.entities.Pauta;
import com.votacao.desafio.api.domain.entities.Voto;
import com.votacao.desafio.api.domain.repository.AssociadoRepository;
import com.votacao.desafio.api.domain.repository.PautaRepository;
import com.votacao.desafio.api.domain.repository.VotoRepository;


@Service
public class VotoService {

    @Autowired
    private VotoRepository votoRepository;

    @Autowired
    private AssociadoRepository associadoRepository;

    @Autowired
    private PautaRepository pautaRepository;

    public Voto votar(Long associadoId, Long pautaId, Boolean voto) {
        Associado associado = associadoRepository.findById(associadoId)
                .orElseThrow(() -> new IllegalArgumentException("Associado não encontrado"));

        Pauta pauta = pautaRepository.findById(pautaId)
                .orElseThrow(() -> new IllegalArgumentException("Pauta não encontrada"));

        if (votoRepository.existsByAssociadoAndPauta(associado, pauta)) {
            throw new IllegalArgumentException("Associado já votou nesta pauta");
        }

        Voto novoVoto = new Voto();
        novoVoto.setAssociado(associado);
        novoVoto.setPauta(pauta);
        novoVoto.setVoto(voto);

        return votoRepository.save(novoVoto);
    }
    
    
	public Voto votarN(Voto voto) {
        
<<<<<<< HEAD
		Associado associado = associadoRepository.findById(voto.getAssociado().getId() )
                .orElseThrow(() -> new IllegalArgumentException("Associado não encontrado"));

        Pauta pauta = pautaRepository.findById(voto.getPauta().getId() )
=======
		/*
		Associado associado = associadoRepository.findById(voto.getAssociadoId())
                .orElseThrow(() -> new IllegalArgumentException("Associado não encontrado"));

        Pauta pauta = pautaRepository.findById(voto.getPautaId())
>>>>>>> e33342494c083583c1a18f95d23a715cd1ce39f3
                .orElseThrow(() -> new IllegalArgumentException("Pauta não encontrada"));


		
        if (votoRepository.existsByAssociadoAndPauta(associado, pauta)) {
            throw new IllegalArgumentException("Associado já votou nesta pauta");
        }  
        
<<<<<<< HEAD
=======
         */
		
>>>>>>> e33342494c083583c1a18f95d23a715cd1ce39f3
        return votoRepository.save(voto);
	}
	
	
	public List<Voto> buscarTodos() {
		
		List<Voto> listaVotos = votoRepository.findAll();
		return listaVotos;		
		
	}

}
