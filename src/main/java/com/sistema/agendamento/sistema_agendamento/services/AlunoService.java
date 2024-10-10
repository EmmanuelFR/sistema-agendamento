package com.sistema.agendamento.sistema_agendamento.services;

import com.sistema.agendamento.sistema_agendamento.models.Aluno;
import com.sistema.agendamento.sistema_agendamento.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    // Salvar ou atualizar um aluno
    public Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    // Buscar um aluno por ID
    public Optional<Aluno> buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id);
    }

    // Listar todos os alunos
    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    // Deletar um aluno
    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }
    
}