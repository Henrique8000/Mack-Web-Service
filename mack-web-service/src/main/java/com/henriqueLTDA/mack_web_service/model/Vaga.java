package com.henriqueLTDA.mack_web_service.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vaga {
	
	@Id
	private Integer id;
	private String titulo;
	private String descricao;
	private LocalDate publicacao;
	private Boolean ativo;
	private Integer idEmpresa;
	
	public Vaga() {
	}
	
	public Vaga(Integer id, String titulo, String descricao, LocalDate publicacao, Boolean ativo, Integer idEmpresa) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.publicacao = publicacao;
		this.ativo = ativo;
		this.idEmpresa = idEmpresa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(LocalDate publicacao) {
		this.publicacao = publicacao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
}
