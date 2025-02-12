package com.sql.Escola.repositors;

import com.sql.Escola.models.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<AlunoModel, Integer> {
}
