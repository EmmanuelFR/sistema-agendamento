package com.sistema.agendamento.sistema_agendamento.models;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
// import java.sql.Time;

@Entity
@Table(name = "agendamentos")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agendamento_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "prova_id")
    private Prova prova;

    @Future(message = "A data do agendamento deve ser futura")
    // private Date data;
    private LocalDateTime data;

    @Column(name = "disciplina")  // Adiciona a disciplina
    private String disciplina;

    @ManyToOne
    @JoinColumn(name = "reagendamento_id")
    private Agendamento reagendamento; // Referencia a si mesma

    @Column(name = "cancelado", nullable = false)
    private boolean cancelado = false; // Por padrão, não cancelado

    @ManyToOne
    @JoinColumn(name = "agendamento_original_id")
    private Agendamento agendamentoOriginal;

    // Getters e Setters
    public Agendamento getAgendamentoOriginal() {
        return agendamentoOriginal;
    }

    public void setAgendamentoOriginal(Agendamento agendamentoOriginal) {
        this.agendamentoOriginal = agendamentoOriginal;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    // public Date getData() {
    //     return data;
    // }

    // public void setData(Date data) {
    //     this.data = data;
    // }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Agendamento getReagendamento() {
        return reagendamento;
    }

    public void setReagendamento(Agendamento reagendamento) {
        this.reagendamento = reagendamento;
    }

}