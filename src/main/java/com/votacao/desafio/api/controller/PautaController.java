package com.votacao.desafio.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.votacao.desafio.api.domain.entities.Pauta;
import com.votacao.desafio.api.domain.service.PautaService;

//import io.swagger.annotations.ApiOperation;

@RestController
//@Api("GerenciadorViagensController")
public class PautaController {

	@Autowired
    private PautaService pautaService;
	
	//@ApiOperation(value = "Cadastra uma viagem")
	@RequestMapping(value = "/v1/pauta/criar", method = RequestMethod.POST, produces = "application/json" )
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	//public ResponseEntity<Pauta> cadastrar(@Validated @RequestBody Pauta pauta) {
	public ResponseEntity<Pauta> cadastrar() {

		// Não devemos expor entidades na resposta.
		//Response<Pauta> response = new Response<Pauta>();
		Pauta pauta = new Pauta();
		Pauta pautaSalva = this.pautaService.salvar(pauta);

		return ResponseEntity.ok(pautaSalva);
	}
	
	//@ApiOperation(value = "Retorna todas as viagens")
	@RequestMapping(value = "/v1/pautas", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Pauta>> listar() {
		List<Pauta> pautas = null;
		pautas = this.pautaService.listarTodas();
		return ResponseEntity.status(HttpStatus.OK).body(pautas);
	}

	
	//@ApiOperation(value = "Retorna todas as viagens")
	@RequestMapping(value = "/v1/pauta/{pautaId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Pauta> buscarPauta(@PathVariable("pautaId") Long pautaId) {
		Pauta pauta = this.pautaService.listarPauta(pautaId);
		return ResponseEntity.status(HttpStatus.OK).body(pauta);
	}

	
}
