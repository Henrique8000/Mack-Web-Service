package com.henriqueLTDA.mack_web_service.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.henriqueLTDA.mack_web_service.model.Estudante;


public interface EstudanteDAO extends CrudRepository<Estudante, Long>{
	public List<Estudante> findAll();
	
}
