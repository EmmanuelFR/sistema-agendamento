package com.sistema.agendamento.sistema_agendamento.models;

import jakarta.persistence.*;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Relacionamento com Curso - Muitos alunos podem pertencer a um curso
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}




// package com.sistema.agendamento.sistema_agendamento.models;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "alunos")
// public class Aluno extends Usuario {
//     // Atributos específicos de Aluno

//     @Id
//     private long id;

//     private String matricula;

//     //private String curso;

//     @ManyToOne
//     @JoinColumn(name = "curso_id")
//     private Curso curso;

//     // Getters e Setters
//     public long getIdAluno() {
//         return id;
//     }

//     public void setIdAluno(long id) {
//         this.id = id;
//     }

//     public String getMatricula() {
//         return matricula;
//     }

//     public void setMatricula(String matricula) {
//         this.matricula = matricula;
//     }

//     public Curso getCurso() {
//         return curso;
//     }

//     public void setCurso(Curso curso) {
//         this.curso = curso;
//     }

//     // public String getCurso() {
//     //     return curso;
//     // }

//     // public void setCurso(String curso) {
//     //     this.curso = curso;
//     // }

// }
