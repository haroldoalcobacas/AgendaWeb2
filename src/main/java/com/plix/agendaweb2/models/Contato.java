package com.plix.agendaweb2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Contato {
	
	@Id
	private Long id;
	private String nome;
	private String fone;
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
	
	

}
