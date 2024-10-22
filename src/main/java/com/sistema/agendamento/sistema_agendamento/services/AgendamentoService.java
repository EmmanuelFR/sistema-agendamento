package com.sistema.agendamento.sistema_agendamento.services;

import com.sistema.agendamento.sistema_agendamento.models.Agendamento;
import com.sistema.agendamento.sistema_agendamento.repositories.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    private static final int LIMITE_VAGAS = 20;

    // Cria um novo agendamento com validação de vagas por horário
    public Agendamento criarAgendamento(Agendamento agendamento) {
        if (isHorarioLotado(agendamento.getDataHora())) {
            throw new IllegalArgumentException("Horário já está cheio, escolha outro.");
        }
        return agendamentoRepository.save(agendamento);
    }

    // Reagenda uma prova, cancelando o agendamento anterior
    public Agendamento reagendarProva(Long id, Agendamento novoAgendamento) {
        // Busca o agendamento existente
        Agendamento agendamentoExistente = agendamentoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado"));

        // Cancela o agendamento anterior
        agendamentoExistente.setCancelado(true);
        agendamentoRepository.save(agendamentoExistente);

        // Define o novo agendamento como reagendamento do anterior
        novoAgendamento.setReagendamento(agendamentoExistente);

        // Cria o novo agendamento com validação de vagas
        return criarAgendamento(novoAgendamento);
    }

    // Verifica se o horário já está lotado
    public boolean isHorarioLotado(LocalDateTime dataHora) {
        List<Agendamento> agendamentosNoHorario = agendamentoRepository.findByDataHora(dataHora);
        return agendamentosNoHorario.size() >= LIMITE_VAGAS;
    }

    public List<Agendamento> listarTodosAgendamentos() {
        return agendamentoRepository.findAll();  // Busca todos os agendamentos no repositório
    }    

    public Agendamento buscarPorId(Long id) {
        return agendamentoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado com o ID: " + id));
    }
    
}