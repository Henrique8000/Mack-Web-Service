package com.henriqueLTDA.mack_web_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.henriqueLTDA.mack_web_service.dao.VagaDAO;
import com.henriqueLTDA.mack_web_service.model.Vaga;


@Service
public class VagaService {
	
	@Autowired
	private VagaDAO vagaDAO;
	
    public void create(Vaga v){
        this.vagaDAO.save(v);
    }
    
    public List<Vaga> getAllVagas(){
        return this.vagaDAO.findAll();
    }
    
    public Vaga getById(Long id){
        return this.vagaDAO.findById(id)
        		.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esutante com o ID " + id + "não encontrado:"));
    }
    
    public void deleteById(Long id) {
    	this.vagaDAO.deleteById(id);
    }
    
    public void updateVaga(Long id, Vaga newVaga) {
    	Vaga e = getById(id);
    	
    	e.setTitulo(newVaga.getTitulo());
    	e.setDescricao(newVaga.getDescricao());
    	e.setPublicacao(newVaga.getPublicacao());
    	e.setAtivo(newVaga.getAtivo());
    	
    	vagaDAO.save(e);
    	
    }
}
