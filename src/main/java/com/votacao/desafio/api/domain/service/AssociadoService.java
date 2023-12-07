package com.votacao.desafio.api.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.votacao.desafio.api.domain.entities.Associado;
import com.votacao.desafio.api.domain.repository.AssociadoRepository;

@Service
public class AssociadoService {

	@Autowired
	AssociadoRepository associadoRepository;
	
	public Associado criar(Associado associado) {
		
        return associadoRepository.save(associado);
	}
	
	
	public List<Associado> buscarTodos() {
		
		List<Associado> associados = associadoRepository.findAll();
		return associados;		
		
	}
	
}
