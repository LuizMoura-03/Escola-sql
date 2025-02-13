package com.sql.Escola.services;

import com.sql.Escola.models.AlunoModel;
import com.sql.Escola.repositors.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoModel> listarAlunos() {
        return alunoRepository.findAll();
    }

    public Optional<AlunoModel> buscarPorId(int id) {
        return alunoRepository.findById(id);
    }

    public AlunoModel salvarAluno(AlunoModel aluno) {
        return alunoRepository.save(aluno);
    }

    public AlunoModel atualizar(int id, AlunoModel alunoAtualizado) {
        AlunoModel aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com ID: " + id));

        aluno.setNome(alunoAtualizado.getNome());
        aluno.setIdade(alunoAtualizado.getIdade());
        return alunoRepository.save(aluno);
    }

    public void deletarAluno(int id) {
        if (!alunoRepository.existsById(id)) {
            throw new RuntimeException("Aluno não encontrado com ID: " + id);
        }
        alunoRepository.deleteById(id);
    }

}
