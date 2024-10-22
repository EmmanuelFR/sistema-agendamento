package com.sistema.agendamento.sistema_agendamento.controllers;

import com.sistema.agendamento.sistema_agendamento.models.Agendamento;
import com.sistema.agendamento.sistema_agendamento.services.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
@CrossOrigin(origins = "http://localhost:3000")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    // Cria um novo agendamento com verificação de limite por horário
    @PostMapping
    public ResponseEntity<Agendamento> criarAgendamento(@RequestBody Agendamento agendamento) {
    System.out.println("Data recebida no formato ISO: " + agendamento.getDataHora());
    Agendamento novoAgendamento = agendamentoService.criarAgendamento(agendamento);
    return ResponseEntity.ok(novoAgendamento);
    }


    // Reagendar prova e cancelar agendamento anterior
    @PutMapping("/reagendar/{id}")
public ResponseEntity<Agendamento> salvarReagendamento(@PathVariable Long id, @RequestBody Agendamento novoAgendamento) {
    // Verifica se o novo horário não está lotado
    if (agendamentoService.isHorarioLotado(novoAgendamento.getDataHora())) {
        return ResponseEntity.badRequest().body(null);  // Horário já lotado
    }

    // Realiza o reagendamento
    Agendamento agendamentoReagendado = agendamentoService.reagendarProva(id, novoAgendamento);
    return ResponseEntity.ok(agendamentoReagendado);
}


    // Lista todos os agendamentos
    @GetMapping
    public ResponseEntity<List<Agendamento>> listarTodosAgendamentos() {
        List<Agendamento> agendamentos = agendamentoService.listarTodosAgendamentos();
        return ResponseEntity.ok(agendamentos);
    }
}