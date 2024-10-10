package com.sistema.agendamento.sistema_agendamento.repositories;

import com.sistema.agendamento.sistema_agendamento.models.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    // Lista todos os agendamentos de um aluno
    List<Agendamento> findByAlunoId(Long alunoId);

    // Lista todos os agendamentos de um aluno em uma data específica
    List<Agendamento> findByAlunoIdAndDataAgendamento(Long alunoId, LocalDate dataAgendamento);
    
}