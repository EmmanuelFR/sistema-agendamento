package com.sistema.agendamento.sistema_agendamento.services;

import com.sistema.agendamento.sistema_agendamento.models.Agendamento;
import com.sistema.agendamento.sistema_agendamento.repositories.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    // Salvar ou atualizar um agendamento
    public Agendamento salvarAgendamento(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    // Buscar um agendamento por ID
    public Optional<Agendamento> buscarAgendamentoPorId(Long id) {
        return agendamentoRepository.findById(id);
    }

    // Listar todos os agendamentos por aluno
    public List<Agendamento> listarAgendamentosPorAluno(Long alunoId) {
        return agendamentoRepository.findByAlunoId(alunoId);
    }

    // Reagendar prova (atualizando um agendamento existente)
    public Agendamento reagendarProva(Long agendamentoId, Agendamento novoAgendamento) {
        Agendamento agendamentoExistente = agendamentoRepository.findById(agendamentoId)
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado"));
        agendamentoExistente.setDataAgendamento(novoAgendamento.getDataAgendamento());
        agendamentoExistente.setHoraAgendamento(novoAgendamento.getHoraAgendamento());
        return agendamentoRepository.save(agendamentoExistente);
    }
    
    // Método para deletar um agendamento por ID
    public void deletarAgendamento(Long id) {
        Optional<Agendamento> agendamentoExistente = agendamentoRepository.findById(id);
        if (agendamentoExistente.isPresent()) {
            agendamentoRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Agendamento não encontrado com ID: " + id);
        }
    }
    
}