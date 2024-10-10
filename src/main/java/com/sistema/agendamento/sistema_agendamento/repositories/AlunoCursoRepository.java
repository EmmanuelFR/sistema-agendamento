package com.sistema.agendamento.sistema_agendamento.repositories;

import com.sistema.agendamento.sistema_agendamento.models.AlunoCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlunoCursoRepository extends JpaRepository<AlunoCurso, Long> {

    // Custom query method para buscar cursos por aluno
    List<AlunoCurso> findByAlunoId(Long alunoId);

    // Custom query method para buscar alunos por curso
    List<AlunoCurso> findByCursoId(Long cursoId);
    
}