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

import com.henriqueLTDA.mack_web_service.entities.Estudante;

@RestController
public class EstudanteController {

	private List<Estudante> estudantes;
	
	public EstudanteController() {
		estudantes = new ArrayList<>();
		
	    estudantes.add(new Estudante(1, "Ana Paula Souza", "ana.souza@email.com", LocalDate.parse("2002-03-15"), 2020));
	    estudantes.add(new Estudante(2, "Carlos Henrique Lima", "carlos.lima@email.com", LocalDate.parse("2001-10-22"), 2019));
	    estudantes.add(new Estudante(3, "Fernanda Oliveira", "fernanda.oliveira@email.com", LocalDate.parse("2003-07-05"), 2021));
	    estudantes.add(new Estudante(4, "Lucas Pereira", "lucas.pereira@email.com", LocalDate.parse("2002-04-11"), 2020));
	    estudantes.add(new Estudante(5, "Gabriela Martins", "gabriela.martins@email.com", LocalDate.parse("2001-12-25"), 2019));
	    estudantes.add(new Estudante(6, "Rafael Costa", "rafael.costa@email.com", LocalDate.parse("2000-09-13"), 2018));
	    estudantes.add(new Estudante(7, "Juliana Silva", "juliana.silva@email.com", LocalDate.parse("2002-06-18"), 2020));
	    estudantes.add(new Estudante(8, "Marcos Vinícius", "marcos.vinicius@email.com", LocalDate.parse("2003-01-30"), 2021));
	    estudantes.add(new Estudante(9, "Camila Azevedo", "camila.azevedo@email.com", LocalDate.parse("2001-11-08"), 2019));
	    estudantes.add(new Estudante(10, "Felipe Cardoso", "felipe.cardoso@email.com", LocalDate.parse("2000-08-27"), 2018));
	}
	
	@GetMapping("/mackenzie/alunos")
	public List<Estudante> getEstudantes() {
		return this.estudantes;
	}

	@GetMapping("/mackenzie/alunos/{id}")
	public Estudante getEstudante(@PathVariable int id) {
		return this.estudantes.get(id);
		}
	
	
	@PostMapping("/mackenzie/alunos/cadastrar")
	public Estudante cadastrarEstudante(@RequestBody Estudante estudante) {
		estudantes.add(estudante);
		return estudante;
	}
	
	@DeleteMapping("/mackenzie/alunos/deletar/{id}")
	public String deletarAluno(@PathVariable int id) {
		
		if (id < 0 || id >= estudantes.size()) {
			return "Estudante não encontrado";
		}
		
		estudantes.remove(id);
		return "Estudante removido com sucesso";
	}
	
	@PutMapping("/mackenzie/alunos/atualizar/{id}")
	public String atualizarEstudante(@PathVariable int id, @RequestBody Estudante novoAluno) {
		
		 if (id < 0 || id >= estudantes.size()) {
		        return "Aluno não encontrado";
		    }

		    estudantes.set(id, novoAluno);
		    return "Aluno atualizado com sucesso";
		    
	}
	
}
