package com.sistema.agendamento.sistema_agendamento.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.agendamento.sistema_agendamento.dto.RedefinirSenhaRequest;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RedefinirSenhaController {

    @PostMapping("/api/redefinir-senha")
    public ResponseEntity<?> redefinirSenha(@RequestBody RedefinirSenhaRequest redefinirSenhaRequest) {
        System.out.println("Senha atual recebida: " + redefinirSenhaRequest.getNovaSenha());
        
        if ("2413".equals(redefinirSenhaRequest.getNovaSenha()) && "2413".equals(redefinirSenhaRequest.getConfirmarSenha())) {
            return ResponseEntity.ok("Senha redefinida com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Senha atual incorreta");
        }
    }
}    