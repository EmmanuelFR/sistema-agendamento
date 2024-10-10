package com.sistema.agendamento.sistema_agendamento.models;

import jakarta.persistence.*;
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

    private Date data;
    //private Time horaAgendamento;

    @ManyToOne
    @JoinColumn(name = "reagendamento_id")
    private Agendamento reagendamento;  // Referencia a si mesma

    // Getters e Setters
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    // public Time getHoraAgendamento() {
    //     return horaAgendamento;
    // }

    // public void setHoraAgendamento(Time horaAgendamento) {
    //     this.horaAgendamento = horaAgendamento;
    // }

    public Agendamento getReagendamento() {
        return reagendamento;
    }

    public void setReagendamento(Agendamento reagendamento) {
        this.reagendamento = reagendamento;
    }

}