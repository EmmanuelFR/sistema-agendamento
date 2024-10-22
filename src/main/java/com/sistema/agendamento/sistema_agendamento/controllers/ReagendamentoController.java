package com.sistema.agendamento.sistema_agendamento.controllers;

import com.sistema.agendamento.sistema_agendamento.models.Agendamento;
import com.sistema.agendamento.sistema_agendamento.services.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reagendamentos")
@CrossOrigin(origins = "http://localhost:3000")
public class ReagendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    // Reagenda uma prova existente, cancelando o agendamento anterior
    @PutMapping("/{id}")
    public ResponseEntity<Agendamento> salvarReagendamento(@PathVariable Long id, @RequestBody Agendamento novoAgendamento) {
        // Verifica se o novo horário não está lotado
        if (agendamentoService.isHorarioLotado(novoAgendamento.getDataHora())) {
            return ResponseEntity.badRequest().body(null);  // Horário já lotado
        }

        // Realiza o reagendamento
        Agendamento agendamentoReagendado = agendamentoService.reagendarProva(id, novoAgendamento);
        return ResponseEntity.ok(agendamentoReagendado);
    }

    // Lista todos os agendamentos existentes para reagendamento
    @GetMapping
    public ResponseEntity<List<Agendamento>> listarAgendamentos() {
        List<Agendamento> agendamentos = agendamentoService.listarTodosAgendamentos();
        return ResponseEntity.ok(agendamentos);
    }

    // Consulta um agendamento específico por ID
    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> buscarAgendamentoPorId(@PathVariable Long id) {
        Agendamento agendamento = agendamentoService.buscarPorId(id);
        return ResponseEntity.ok(agendamento);
    }
}