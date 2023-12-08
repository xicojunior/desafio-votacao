package com.votacao.desafio.api.domain.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CpfValidacaoFacade {

    public ResponseEntity<String> validateCpf(String cpf) {
        
        if ( this.isCPF( Long.valueOf(cpf)) ) {
        	return ResponseEntity.ok("{\"status\": \"ABLE_TO_VOTE\"}");
        } else {
        	return ResponseEntity.status(404).body("{\"status\": \"UNABLE_TO_VOTE\"}");
        }

    }
    
    public boolean isCPF(Long value) {

    	  final int valueSize = value.toString().length();
    	  
    	  if (valueSize > 12) {
    	   return false;
    	  } else {
    		  return true;
    	  }    	  
    	  
    	 }
    
}
