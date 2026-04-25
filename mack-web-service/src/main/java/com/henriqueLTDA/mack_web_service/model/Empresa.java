package com.henriqueLTDA.mack_web_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Empresa {
	
	@Id
	private Integer id;
	private String nome;
	private String cnpj;
	private String emailContato;
	
	public Empresa() {
	}
	
	public Empresa(Integer id, String nome, String cnpj, String emailContato) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.emailContato = emailContato;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmailContato() {
		return emailContato;
	}

	public void setEmailContato(String emailContato) {
		this.emailContato = emailContato;
	}
	
}
