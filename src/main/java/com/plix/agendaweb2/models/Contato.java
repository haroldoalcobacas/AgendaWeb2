package com.plix.agendaweb2.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	private String fone;
	@Enumerated(EnumType.STRING)
	private StatusContato statusContato;
	
	
	
	public Contato() {	
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public StatusContato getStatusContato() {
		return statusContato;
	}

	public void setStatusContato(StatusContato statusContato) {
		this.statusContato = statusContato;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + 
				", nome=" + nome +
				", fone=" + fone + 
				", statusContato=" + statusContato + "]";
	}
	
	

}
