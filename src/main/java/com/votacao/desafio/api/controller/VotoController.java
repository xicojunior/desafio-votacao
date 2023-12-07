package com.votacao.desafio.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.votacao.desafio.api.domain.entities.Voto;
import com.votacao.desafio.api.domain.service.VotoService;

@RestController
public class VotoController {

    @Autowired
    private VotoService votoService;

<<<<<<< HEAD
=======
    
	//@ApiOperation(value = "Cadastra uma viagem")
>>>>>>> e33342494c083583c1a18f95d23a715cd1ce39f3
	@RequestMapping(value = "/v1/voto/votar", method = RequestMethod.POST, consumes = "application/json", produces = "application/json" )
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
    public ResponseEntity<Voto> votar(@PathVariable("associadoId") Long associadoId, 
    								  @PathVariable("pautaId") Long pautaId, 
    								  @PathVariable("voto") Boolean voto) {
        try {
            Voto votoSalvo = votoService.votar(associadoId, pautaId, voto);
            return ResponseEntity.ok(votoSalvo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
	
	
<<<<<<< HEAD
=======
	//@ApiOperation(value = "Cadastra uma viagem")
>>>>>>> e33342494c083583c1a18f95d23a715cd1ce39f3
	@RequestMapping(value = "/v1/voto/votare", method = RequestMethod.POST, consumes = "application/json", produces = "application/json" )
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
    public ResponseEntity<Voto> votare(@RequestBody Voto voto) {
        try {
            Voto votoSalvo = votoService.votarN(voto);
            return ResponseEntity.ok(votoSalvo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
    
    
	/*    
    @PostMapping("/votar")
    public ResponseEntity<Voto> votarDois(@RequestParam Long associadoId, @RequestParam Long pautaId, @RequestParam Boolean voto) {
        try {
            Voto votoSalvo = votoService.votar(associadoId, pautaId, voto);
            return ResponseEntity.ok(votoSalvo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
    */
	
	
<<<<<<< HEAD
=======
	//@ApiOperation(value = "Retorna todas as viagens")
>>>>>>> e33342494c083583c1a18f95d23a715cd1ce39f3
	@RequestMapping(value = "/v1/votos", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Voto>> listar() {
		List<Voto> votos = null;
		votos = this.votoService.buscarTodos();
		//return ResponseEntity.status(HttpStatus.OK).body(votos);
		return ResponseEntity.ok(votos);
	}
   
    
}
