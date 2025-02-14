package com.sql.Escola.controllers;

import com.sql.Escola.models.AlunoModel;
import com.sql.Escola.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoModel>> listarAlunos() {
        List<AlunoModel> alunos = alunoService.listarAlunos();
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoModel> buscarPorId(@PathVariable int id) {
        Optional<AlunoModel> aluno = alunoService.buscarPorId(id);
        if (aluno.isPresent()) {
            return ResponseEntity.ok(aluno.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<AlunoModel> salvarAluno(@Valid @RequestBody AlunoModel aluno) {
        AlunoModel alunoSalvo = alunoService.salvarAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoModel> atualizarAluno(@PathVariable int id, @Valid @RequestBody AlunoModel alunoAtualizado) {
        try {
            AlunoModel aluno = alunoService.atualizar(id, alunoAtualizado);
            return ResponseEntity.ok(aluno);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable int id) {
            alunoService.deletarAluno(id);
            return ResponseEntity.noContent().build();
    }
}
