package com.sistema.agendamento.sistema_agendamento.dto;

public class RedefinirSenhaRequest {
    private String novaSenha;
    private String confirmarSenha;

    // Getters e Setters
    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }
}