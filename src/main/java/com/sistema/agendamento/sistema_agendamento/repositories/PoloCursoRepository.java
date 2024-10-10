package com.sistema.agendamento.sistema_agendamento.repositories;

import com.sistema.agendamento.sistema_agendamento.models.PoloCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PoloCursoRepository extends JpaRepository<PoloCurso, Long> {

    // Custom query method para buscar cursos por polo
    List<PoloCurso> findByPoloId(Long poloId);

    // Custom query method para buscar polos por curso
    List<PoloCurso> findByCursoId(Long cursoId);
    
}