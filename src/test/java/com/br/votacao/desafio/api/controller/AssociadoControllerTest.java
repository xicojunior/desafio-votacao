package com.br.votacao.desafio.api.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.votacao.desafio.api.controller.AssociadoController;
import com.votacao.desafio.api.domain.entities.Associado;
import com.votacao.desafio.api.domain.service.AssociadoService;

//@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebMvcTest(AssociadoController.class)
public class AssociadoControllerTest {
	
	@MockBean
	AssociadoService associadoService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void criarAssociado() throws Exception {

		
	}
	

}
