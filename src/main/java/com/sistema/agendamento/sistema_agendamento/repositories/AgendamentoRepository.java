package com.sistema.agendamento.sistema_agendamento.repositories;

import com.sistema.agendamento.sistema_agendamento.models.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    // Encontra todos os agendamentos ativos (não cancelados)
    List<Agendamento> findByCanceladoFalse();

    // Encontra agendamentos por disciplina
    List<Agendamento> findByDisciplina(String disciplina);

    // Encontra agendamentos por data e hora
    List<Agendamento> findByDataHora(LocalDateTime dataHora); // Altere o nome para refletir que está lidando com data e hora

    // Encontra agendamentos para um aluno específico
    List<Agendamento> findByAlunoId(Long alunoId);

    // Encontra agendamentos de uma disciplina em uma data específica
    List<Agendamento> findByDisciplinaAndDataHora(String disciplina, LocalDateTime dataHora);
}