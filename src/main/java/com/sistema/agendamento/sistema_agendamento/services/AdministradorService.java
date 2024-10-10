package com.sistema.agendamento.sistema_agendamento.services;


import com.sistema.agendamento.sistema_agendamento.models.Administrador;
import com.sistema.agendamento.sistema_agendamento.repositories.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    // Salvar ou atualizar um administrador
    public Administrador salvarAdministrador(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    // Buscar um administrador por ID
    public Optional<Administrador> buscarAdministradorPorId(Long id) {
        return administradorRepository.findById(id);
    }

    // Listar todos os administradores
    public List<Administrador> listarAdministradores() {
        return administradorRepository.findAll();
    }

    // Deletar um administrador
    public void deletarAdministrador(Long id) {
        administradorRepository.deleteById(id);
    }
    
}