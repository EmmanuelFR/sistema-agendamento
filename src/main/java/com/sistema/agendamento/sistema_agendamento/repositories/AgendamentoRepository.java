package com.sistema.agendamento.sistema_agendamento.repositories;

import com.sistema.agendamento.sistema_agendamento.models.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    // Lista todos os agendamentos de um aluno
    List<Agendamento> findByAlunoId(Long alunoId);

    // Lista todos os agendamentos de um aluno em uma data específica
    List<Agendamento> findByAlunoIdAndData(Long alunoId, Date data);
    
    // @Query(value = "SELECT * FROM alunos")
    // List<Agendamento> ObterReagendamentos(Long alunoId);

}