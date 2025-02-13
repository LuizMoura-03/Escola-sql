package com.sql.Escola.services;

import com.sql.Escola.models.AlunoModel;
import com.sql.Escola.repositors.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<AlunoModel> listarAlunos() {
        return alunoRepository.findAll();
    }

    public Optional<AlunoModel> buscarPorId(int id) {
        return alunoRepository.findById(id);
    }

    public AlunoModel salvarAluno(AlunoModel aluno) {
        return alunoRepository.save(aluno);
    }

}
