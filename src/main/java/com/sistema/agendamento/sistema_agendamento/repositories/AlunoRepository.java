package com.sistema.agendamento.sistema_agendamento.repositories;

import com.sistema.agendamento.sistema_agendamento.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    // Buscar alunos pelo ID do curso ao qual eles pertencem
    List<Aluno> findByCurso_Id(Long cursoId);
}



// package com.sistema.agendamento.sistema_agendamento.repositories;

// import com.sistema.agendamento.sistema_agendamento.models.Aluno;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.List;

// public interface AlunoRepository extends JpaRepository<Aluno, Long> {

//     // Custom query method para listar alunos por curso
//     List<Aluno> findByCurso_Id(Long cursoId);
    
// }