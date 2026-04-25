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

import com.henriqueLTDA.mack_web_service.model.Empresa;
import com.henriqueLTDA.mack_web_service.service.EmpresaService;

@RestController
@RequestMapping("/mackenzie/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping("/todos")
	public List<Empresa> getAll() {
		return this.empresaService.getAllEstudante();
	}

	@GetMapping("/{id}")
	public Empresa getByName(@PathVariable long id) {
		return this.empresaService.getById(id);
		}
		
	@PostMapping("/cadastrar")
	public void cadastrarEstudante(@RequestBody Empresa empresa) {
		this.empresaService.create(empresa);
	}
	
	
	@DeleteMapping("/deletar/{id}")
	public void deletarAluno(@PathVariable long id) {
		this.empresaService.deleteById(id);
	}
	
	@PutMapping("/atualizar/{id}")
	public void atualizarEstudante(@PathVariable long id, @RequestBody Empresa novaEmpresa) {
		empresaService.updateEstudante(id, novaEmpresa);
	}
	
}
