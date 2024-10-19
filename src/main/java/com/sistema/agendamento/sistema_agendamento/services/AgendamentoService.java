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

     // Método para listar todos os agendamentos
     public List<Agendamento> listarTodosAgendamentos() {
        return agendamentoRepository.findAll();
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
    public Agendamento reagendarProva(Long id, Agendamento novoAgendamento) {
        // Busca o agendamento existente
        Agendamento agendamentoExistente = agendamentoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado"));
    
        // Cancela o agendamento anterior
        agendamentoExistente.setCancelado(true); // Certifique-se de que a coluna 'cancelado' existe na tabela Agendamento
        agendamentoRepository.save(agendamentoExistente); // Salva o agendamento cancelado
    
        // Salva o novo agendamento
        novoAgendamento.setReagendamento(agendamentoExistente); // Linka o novo ao antigo
        return agendamentoRepository.save(novoAgendamento);
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