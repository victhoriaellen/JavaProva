package br.com.alunonline.api.controller;

import br.com.alunonline.api.model.Professor;
import br.com.alunonline.api.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @ResponseStatus(HttpStatus.CREATED)
    public void criarProfessor(@RequestBody Professor professor) {
        professorService.criarProfessor(professor);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Professor> listarTodosProfessores(){
        return professorService.listarTodosProfessores();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Professor> professorPorId(@PathVariable Long id){
        return professorService.professorPorId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarProfessorPorId(@PathVariable Long id){
        professorService.deletarProfessorPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarProfessorPorId(@PathVariable Long id, @RequestBody Professor professorEditado){
        professorService.atualizarProfessorPorId(id, professorEditado);
    }
}
