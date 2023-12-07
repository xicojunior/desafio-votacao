package com.votacao.desafio.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.votacao.desafio.api.domain.entities.Associado;
import com.votacao.desafio.api.domain.service.AssociadoService;

@Controller
public class AssociadoController {
	
	@Autowired
	AssociadoService associadoService;
	
	@RequestMapping(value = "/v1/associado/criar", method = RequestMethod.POST, produces = "application/json" )
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseEntity<Associado> cadastrar() {

		Associado associado = new Associado();
		Associado associadoSalvo = this.associadoService.criar(associado);

		return ResponseEntity.ok(associadoSalvo);
	}
	
	@RequestMapping(value = "/v1/associados", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Associado>> listar() {
		List<Associado> associados = null;
		associados = this.associadoService.buscarTodos();
		return ResponseEntity.status(HttpStatus.OK).body(associados);
	}
	

}
