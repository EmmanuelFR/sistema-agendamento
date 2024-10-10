package com.sistema.agendamento.sistema_agendamento.repositories;

import com.sistema.agendamento.sistema_agendamento.models.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalTime;
import java.util.List;

public interface HorarioRepository extends JpaRepository<Horario, Long> {

    // Custom query method para buscar horários por polo
    List<Horario> findByPoloId(Long poloId);

    // Custom query method para buscar horários dentro de um intervalo de tempo
    List<Horario> findByHorarioInicioBetween(LocalTime inicio, LocalTime fim);
        
}