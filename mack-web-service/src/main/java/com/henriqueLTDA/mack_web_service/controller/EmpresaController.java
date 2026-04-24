package com.henriqueLTDA.mack_web_service.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.henriqueLTDA.mack_web_service.model.Empresa;

@RestController
public class EmpresaController {

	private List<Empresa> empresas;

	public EmpresaController() {
		empresas = new ArrayList<>();

		empresas.add(new Empresa(1, "Empresa Alfa LTDA", "12.345.678/0001-90", "contato@empresa-alfa.com"));
		empresas.add(new Empresa(2, "Beta Comércio ME", "98.765.432/0001-10", "beta@comercio.com"));
		empresas.add(new Empresa(3, "Gamma Serviços S.A", "11.222.333/0001-44", "servicos@gamma.com"));
		empresas.add(new Empresa(4, "Delta Engenharia", "22.333.444/0001-55", "beta@comercio.com"));
		empresas.add(new Empresa(5, "Epsilon Digital", "33.444.555/0001-66", "email@epsilondigital.com"));

	}

	@GetMapping("/mackenzie/empresas")
	public List<Empresa> getEmpresas() {
		return this.empresas;
	}

	@GetMapping("mackenzie/empresas/{index}")
	public Empresa getSingleEmpresa(@PathVariable int index) {
		return this.empresas.get(index);
	}

	@PostMapping("mackenzie/empresas/cadastrar")
	public Empresa cadastraEmpresa(@RequestBody Empresa empresa) {
		empresas.add(empresa);
		return empresa;
	}

	@PutMapping("mackenzie/empresas/atualizar/{index}")
	public String atualizaEmpresa(@PathVariable int index, @RequestBody Empresa novaEmpresa) {

		if (index < 0 || index >= empresas.size()) {
			return "Empresa não encontrada";
		}

		empresas.set(index, novaEmpresa);
		return "Empresa atualizada com sucesso";

	}

	@DeleteMapping("/mackenzie/empresas/deletar/{index}")
	public String removeEmpresa(@PathVariable int index, @RequestBody Empresa novaEmpresa) {
		
		if (index < 0 || index >= empresas.size()) {
			return "Estudante não encontrado";
		}
		
		empresas.remove(index);
		return "Estudante removido com sucesso";
	}
	
}
