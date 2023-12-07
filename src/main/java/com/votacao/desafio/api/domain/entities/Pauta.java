package com.votacao.desafio.api.domain.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Pauta implements Serializable{

	private static final long serialVersionUID = -8283905995571423428L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @OneToMany(mappedBy = "pauta")
    @Column(name = "votos")
    @JsonIgnore
    private List<Voto> votos;
    
    @Column(name = "descricao")
    private String descricao;


    public Pauta() {}

    public Pauta(String descricao) {
        this.descricao = descricao;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pauta)) return false;
        Pauta pauta = (Pauta) o;
        return Objects.equals(id, pauta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int contarVotosPositivos() {
        return (int) votos.stream().filter(Voto::getVoto).count();
    }

    public int contarVotosNegativos() {
        return (int) votos.stream().filter(v -> !v.getVoto()).count();
    }

    public String resultadoVotacao() {
        int votosPositivos = contarVotosPositivos();
        int votosNegativos = contarVotosNegativos();

        if (votosPositivos > votosNegativos) {
            return "Aprovação da Pauta";
        } else if (votosNegativos > votosPositivos) {
            return "Rejeição da Pauta";
        } else {
            return "Empate";
        }
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
    
    
    
}
