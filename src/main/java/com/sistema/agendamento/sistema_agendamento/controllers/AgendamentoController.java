package com.sistema.agendamento.sistema_agendamento.controllers;

import com.sistema.agendamento.sistema_agendamento.models.Agendamento;
import com.sistema.agendamento.sistema_agendamento.services.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<Agendamento> salvarAgendamento(@RequestBody Agendamento agendamento) {
        return ResponseEntity.ok(agendamentoService.salvarAgendamento(agendamento));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Agendamento>> buscarAgendamentoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(agendamentoService.buscarAgendamentoPorId(id));
    }

    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<Agendamento>> listarAgendamentosPorAluno(@PathVariable Long alunoId) {
        return ResponseEntity.ok(agendamentoService.listarAgendamentosPorAluno(alunoId));
    }

    @PutMapping("/reagendar/{id}")
    public ResponseEntity<Agendamento> reagendarProva(@PathVariable Long id, @RequestBody Agendamento novoAgendamento) {
        return ResponseEntity.ok(agendamentoService.reagendarProva(id, novoAgendamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAgendamento(@PathVariable Long id) {
        agendamentoService.deletarAgendamento(id);
        return ResponseEntity.noContent().build();
    }

}