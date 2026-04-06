package br.com.alunonline.api.controller;

import br.com.alunonline.api.model.Aluno;
import br.com.alunonline.api.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @ResponseStatus(HttpStatus.CREATED)
    public void criarAluno(@RequestBody Aluno aluno) {
        alunoService.criarAluno(aluno);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> listarTodosAlunos(){
        return alunoService.listarTodosAlunos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Aluno> buscarAlunoporid(@PathVariable Long id){
        return alunoService.buscarAlunoporid(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAlunoPorId(@PathVariable Long id){
        alunoService.deletarAlunoPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarAlunoPorId(@PathVariable Long id, @RequestBody Aluno alunoEditado){
        alunoService.atualizarAlunoPorId(id, alunoEditado);
    }
}
