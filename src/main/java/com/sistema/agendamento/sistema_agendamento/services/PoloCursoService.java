package com.sistema.agendamento.sistema_agendamento.services;

import com.sistema.agendamento.sistema_agendamento.models.PoloCurso;
import com.sistema.agendamento.sistema_agendamento.repositories.PoloCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoloCursoService {

    @Autowired
    private PoloCursoRepository poloCursoRepository;

    // Salvar ou atualizar relacionamento Polo-Curso
    public PoloCurso salvarPoloCurso(PoloCurso poloCurso) {
        return poloCursoRepository.save(poloCurso);
    }

    // Buscar relacionamento Polo-Curso por ID
    public Optional<PoloCurso> buscarPoloCursoPorId(Long id) {
        return poloCursoRepository.findById(id);
    }

    // Listar todos os cursos de um polo
    public List<PoloCurso> listarCursosPorPolo(Long poloId) {
        return poloCursoRepository.findByPoloId(poloId);
    }

    // Listar todos os polos que oferecem um curso
    public List<PoloCurso> listarPolosPorCurso(Long cursoId) {
        return poloCursoRepository.findByCursoId(cursoId);
    }

    // Deletar relacionamento Polo-Curso
    public void deletarPoloCurso(Long id) {
        poloCursoRepository.deleteById(id);
    }

}