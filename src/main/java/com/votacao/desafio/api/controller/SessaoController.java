package com.votacao.desafio.api.controller;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.votacao.desafio.api.domain.entities.Sessao;
import com.votacao.desafio.api.domain.service.SessaoService;

@RestController
public class SessaoController {

    @Autowired
    private SessaoService sessaoService;

	@RequestMapping(value = "/v1/sessao/{pautaId}", method = RequestMethod.POST, produces = "application/json" )
	@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Sessao> abrirSessao(@PathVariable Long pautaId) {
        try {
        	Duration duracao = null;
        	Sessao sessaoAberta = sessaoService.abrirSessao(pautaId, duracao);
            return ResponseEntity.ok(sessaoAberta);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
	
	
    @PostMapping("/{pautaId}")
    public ResponseEntity<Sessao> abrirSessao(@PathVariable Long pautaId, @RequestParam(required = false) Duration duracao) {
        try {
            Sessao sessao = sessaoService.abrirSessao(pautaId, duracao);
            return ResponseEntity.ok(sessao);
        } catch (IllegalArgumentException e) {
            e.printStackTrace(); // Log the exception
            throw e;
        }
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

	@RequestMapping(value = "/v1/sessoes", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Sessao>> listar() {
		List<Sessao> sessoes = null;
		sessoes = this.sessaoService.listarTodas();
		return ResponseEntity.status(HttpStatus.OK).body(sessoes);
	}
    
    
}
