package com.henriqueLTDA.mack_web_service.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.henriqueLTDA.mack_web_service.model.Vaga;


public interface VagaDAO extends CrudRepository<Vaga, Long>{
	public List<Vaga> findAll();
}
