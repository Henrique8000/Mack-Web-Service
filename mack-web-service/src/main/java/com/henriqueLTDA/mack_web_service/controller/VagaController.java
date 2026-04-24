package com.henriqueLTDA.mack_web_service.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.henriqueLTDA.mack_web_service.model.Vaga;

@RestController
public class VagaController {
	
	private List<Vaga> vagas;
	
	public VagaController() {
		vagas = new ArrayList<>();
		
		vagas.add(new Vaga(1, "Desenvolvedor Java", "Atuação em projetos backend com Java e Spring. Experiência desejada em APIs REST.", LocalDate.parse("2025-10-01"), true, 1));
		vagas.add(new Vaga(2, "Analista de Suporte Técnico", "Suporte a clientes, resolução de chamados e participação em treinamentos internos.", LocalDate.parse("2025-09-27"), true, 2));
	}
	
	@GetMapping("/mackenzie/vagas")
	public List<Vaga> getVagas() {
		return this.vagas;
	}
	
	@GetMapping("mackenzie/vagas/{index}")
	public Vaga getSingleEmpresa(@PathVariable int index) {
		return this.vagas.get(index);
	}
	
	@PostMapping("mackenzie/vagas/cadastrar")
	public Vaga cadastraEmpresa(@RequestBody Vaga vaga) {
		vagas.add(vaga);
		return vaga;
	}

	@PutMapping("mackenzie/vagas/atualizar/{index}")
	public String atualizaEmpresa(@PathVariable int index, @RequestBody Vaga novaVaga) {

		if (index < 0 || index >= vagas.size()) {
			return "Empresa não encontrada";
		}

		vagas.set(index, novaVaga);
		return "Empresa atualizada com sucesso";

	}

	@DeleteMapping("/mackenzie/vagas/deletar/{index}")
	public String removeEmpresa(@PathVariable int index, @RequestBody Vaga novaVaga) {
		
		if (index < 0 || index >= vagas.size()) {
			return "Estudante não encontrado";
		}
		
		vagas.remove(index);
		return "Estudante removido com sucesso";
	}
	
}
