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

    private static final int LIMITE_VAGAS = 2; // Limite máximo de agendamentos por horário

    // Cria um agendamento com validação de vagas por horário
    public Agendamento criarAgendamento(Agendamento agendamento) {
        // Verifica se o horário já está lotado
        if (isHorarioLotado(agendamento.getDataHora())) {
            throw new IllegalArgumentException("Horário já está cheio, escolha outro.");
        }

        return agendamentoRepository.save(agendamento);
    }

    // Lista todos os agendamentos
    public List<Agendamento> listarTodosAgendamentos() {
        return agendamentoRepository.findAll();
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

    // Método para verificar se o horário já está lotado
    public boolean isHorarioLotado(LocalDateTime dataHora) {
        List<Agendamento> agendamentosNoHorario = agendamentoRepository.findByDataHora(dataHora);
        return agendamentosNoHorario.size() >= LIMITE_VAGAS;
    }
}