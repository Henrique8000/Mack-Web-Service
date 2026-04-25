package com.henriqueLTDA.mack_web_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henriqueLTDA.mack_web_service.model.Vaga;
import com.henriqueLTDA.mack_web_service.service.VagaService;

@RestController
@RequestMapping("/mackenzie/vagas")
public class VagaController {
	
	@Autowired
	private VagaService vagaService;
	
	@GetMapping("/todos")
	public List<Vaga> getAll() {
		return this.vagaService.getAllVagas();
	}

	@GetMapping("/{id}")
	public Vaga getByName(@PathVariable long id) {
		return this.vagaService.getById(id);
		}
		
	@PostMapping("/cadastrar")
	public void cadastrarEstudante(@RequestBody Vaga vaga) {
		this.vagaService.create(vaga);
	}
	
	@DeleteMapping("/deletar/{id}")
	public void deletarAluno(@PathVariable long id) {
		this.vagaService.deleteById(id);
	}
	
	@PutMapping("/atualizar/{id}")
	public void atualizarVaga(@PathVariable long id, @RequestBody Vaga novaVaga) {
		vagaService.updateVaga(id, novaVaga);
	}
	
}
