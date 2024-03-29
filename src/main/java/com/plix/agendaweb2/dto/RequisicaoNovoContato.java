package com.plix.agendaweb2.dto;

import com.plix.agendaweb2.models.Contato;
import com.plix.agendaweb2.models.StatusContato;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RequisicaoNovoContato {

	@NotBlank
	@NotNull
	private String nome;
	@NotBlank
	@NotNull
	private String fone;
	private StatusContato statusContato;
	
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
	
	public Contato toContato() {
		Contato contato = new Contato();
		contato.setNome(this.nome);
		contato.setFone(this.fone);
		contato.setStatusContato(this.statusContato);
		return contato;
		
	}
	

		
	public Contato toContato(Contato contato) {	
		contato.setNome(this.nome);
		contato.setFone(this.fone);
		contato.setStatusContato(this.statusContato);
		return contato;		
		
	}
	
	// passar atualizações para contato
	public void fromContato(Contato contato) {
		this.nome = contato.getNome();
		this.fone = contato.getFone();
		this.statusContato = contato.getStatusContato();
		
	}
	
        
     
  

	@Override
	public String toString() {
		return "RequisicaoNovoContato [nome=" + nome + ", fone=" + fone + ", statusContato=" + statusContato + "]";
	}
	
	
	
}

