package com.henriqueLTDA.mack_web_service.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.henriqueLTDA.mack_web_service.model.Empresa;

public interface EmpresaDAO extends CrudRepository<Empresa, Long>{
	public List<Empresa> findAll();
}
