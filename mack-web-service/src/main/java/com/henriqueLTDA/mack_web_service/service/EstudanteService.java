package com.henriqueLTDA.mack_web_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.henriqueLTDA.mack_web_service.dao.EstudanteDAO;
import com.henriqueLTDA.mack_web_service.model.Estudante;

@Service
public class EstudanteService {
	
	@Autowired
	private EstudanteDAO estudanteDAO;
	
    public void create(Estudante v){
        this.estudanteDAO.save(v);
    }
    
    public List<Estudante> getAllEstudante(){
        return this.estudanteDAO.findAll();
    }
    
    public Estudante getById(Long id){
        return this.estudanteDAO.findById(id)
        		.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esutante com o ID " + id + "não encontrado:"));
    }
    
    public void deleteById(Long id) {
    	this.estudanteDAO.deleteById(id);
    }
    
    public void updateEstudante(Long id, Estudante newEstudante) {
    	Estudante e = getById(id);
    	
    	e.setNome(newEstudante.getNome());
    	e.setEmail(newEstudante.getEmail());
    	e.setNascimento(newEstudante.getNascimento());
    	e.setAnoIngresso(newEstudante.getAnoIngresso());
    	
    	estudanteDAO.save(e);
    	
    }
    
}
