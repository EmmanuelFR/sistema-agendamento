package com.sistema.agendamento.sistema_agendamento.controllers;

import com.sistema.agendamento.sistema_agendamento.models.Agendamento;
import com.sistema.agendamento.sistema_agendamento.services.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping("/api/agendamentos")
    public ResponseEntity<Agendamento> salvarAgendamento(@RequestBody Agendamento agendamento) {
        Agendamento savedAgendamento = agendamentoService.salvarAgendamento(agendamento);
        System.out.println("ID: " + agendamento.getId());
        System.out.println("Data: " + agendamento.getData());
            return ResponseEntity.ok(savedAgendamento);
    }

    @GetMapping("/api/agendamentos")
    public ResponseEntity<List<Agendamento>> buscarAgendamentos() {
    List<Agendamento> agendamentos = agendamentoService.listarTodosAgendamentos();
    return ResponseEntity.ok(agendamentos);
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
    Agendamento reagendado = agendamentoService.reagendarProva(id, novoAgendamento);
    return ResponseEntity.ok(reagendado);
}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAgendamento(@PathVariable Long id) {
        agendamentoService.deletarAgendamento(id);
        return ResponseEntity.noContent().build();
    }

}