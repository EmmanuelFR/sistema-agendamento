package com.sistema.agendamento.sistema_agendamento.services;

import com.sistema.agendamento.sistema_agendamento.models.Curso;
import com.sistema.agendamento.sistema_agendamento.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    // Salvar ou atualizar um curso
    public Curso salvarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    // Buscar um curso por ID
    public Optional<Curso> buscarCursoPorId(Long id) {
        return cursoRepository.findById(id);
    }

    // Listar todos os cursos
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    // Deletar um curso por ID
    public void deletarCurso(Long id) {
        Optional<Curso> cursoExistente = cursoRepository.findById(id);
        if (cursoExistente.isPresent()) {
            cursoRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Curso não encontrado com ID: " + id);
        }
    }

}