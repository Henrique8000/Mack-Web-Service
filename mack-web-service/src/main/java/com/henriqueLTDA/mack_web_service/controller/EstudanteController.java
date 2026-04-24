package com.henriqueLTDA.mack_web_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.henriqueLTDA.mack_web_service.model.Estudante;
import com.henriqueLTDA.mack_web_service.service.EstudanteService;

@RestController
@RequestMapping("/mackenzie/estudante")
public class EstudanteController {
	
	@Autowired
	private EstudanteService estudanteService;
	
	@GetMapping("/todos")
	public List<Estudante> getAll() {
		return this.estudanteService.getAllEstudante();
	}

	@GetMapping("/{id}")
	public Estudante getByName(@PathVariable long id) {
		return this.estudanteService.getById(id);
		}
		
	@PostMapping("/cadastrar")
	public void cadastrarEstudante(@RequestBody Estudante estudante) {
		this.estudanteService.create(estudante);
	}
	
	@DeleteMapping("/deletar/{id}")
	public void deletarAluno(@PathVariable long id) {
		this.estudanteService.deleteById(id);
	}
	
	@PutMapping("/atualizar/{id}")
	public void atualizarEstudante(@PathVariable long id, @RequestBody Estudante novoAluno) {
		estudanteService.updateEstudante(id, novoAluno);
	}
}
