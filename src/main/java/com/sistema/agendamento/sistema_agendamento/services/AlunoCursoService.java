package com.sistema.agendamento.sistema_agendamento.services;

import com.sistema.agendamento.sistema_agendamento.models.AlunoCurso;
import com.sistema.agendamento.sistema_agendamento.repositories.AlunoCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoCursoService {

    @Autowired
    private AlunoCursoRepository alunoCursoRepository;

    // Salvar ou atualizar relacionamento Aluno-Curso
    public AlunoCurso salvarAlunoCurso(AlunoCurso alunoCurso) {
        return alunoCursoRepository.save(alunoCurso);
    }

    // Buscar relacionamento Aluno-Curso por ID
    public Optional<AlunoCurso> buscarAlunoCursoPorId(Long id) {
        return alunoCursoRepository.findById(id);
    }

    // Listar todos os cursos de um aluno
    public List<AlunoCurso> listarCursosPorAluno(Long alunoId) {
        return alunoCursoRepository.findByAlunoId(alunoId);
    }

    // Listar todos os alunos de um curso
    public List<AlunoCurso> listarAlunosPorCurso(Long cursoId) {
        return alunoCursoRepository.findByCursoId(cursoId);
    }

    // Deletar relacionamento Aluno-Curso
    public void deletarAlunoCurso(Long id) {
        alunoCursoRepository.deleteById(id);
    }

}