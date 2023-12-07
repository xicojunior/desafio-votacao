package com.votacao.desafio.api.domain.service;


import com.votacao.desafio.api.domain.entities.Pauta;
import com.votacao.desafio.api.domain.entities.Sessao;
import com.votacao.desafio.api.domain.repository.PautaRepository;
import com.votacao.desafio.api.domain.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SessaoService {

    @Autowired
    private SessaoRepository sessaoRepository;

    @Autowired
    private PautaRepository pautaRepository;

    public Sessao abrirSessao(Long pautaId, Duration duracao) {
<<<<<<< HEAD
    	
=======
>>>>>>> e33342494c083583c1a18f95d23a715cd1ce39f3
        // Verifica se a Pauta existe
        Optional<Pauta> pautaOpt = pautaRepository.findById(pautaId);
        Pauta pauta = pautaOpt.orElseThrow(() -> new IllegalArgumentException("Pauta não encontrada: " + pautaId));

        // Cria e configura a nova Sessao
        Sessao sessao = new Sessao();
        sessao.setPauta(pauta);
        sessao.setDataInicio(LocalDateTime.now());
        sessao.setDataFim(LocalDateTime.now().plus(duracao != null ? duracao : Duration.ofMinutes(1)));
        sessao.setStatus(Sessao.Status.ABERTA);

        // Salva a Sessao no repositório (ou realiza outras operações necessárias)
        sessaoRepository.save(sessao);

        return sessao;
    }
    
<<<<<<< HEAD
    public List<Sessao> listarTodas() {    	
=======
    public List<Sessao> listarTodas() {
    	
>>>>>>> e33342494c083583c1a18f95d23a715cd1ce39f3
    	List<Sessao> sessoes = sessaoRepository.findAll();
    	return sessoes;
    	
    }

}
