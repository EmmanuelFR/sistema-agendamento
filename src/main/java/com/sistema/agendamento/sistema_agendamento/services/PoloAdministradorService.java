package com.sistema.agendamento.sistema_agendamento.services;

import com.sistema.agendamento.sistema_agendamento.models.PoloAdministrador;
import com.sistema.agendamento.sistema_agendamento.repositories.PoloAdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoloAdministradorService {

    @Autowired
    private PoloAdministradorRepository poloAdministradorRepository;

    // Salvar ou atualizar um relacionamento Polo-Administrador
    public PoloAdministrador salvarPoloAdministrador(PoloAdministrador poloAdministrador) {
        return poloAdministradorRepository.save(poloAdministrador);
    }

    // Buscar relacionamento Polo-Administrador por ID
    public Optional<PoloAdministrador> buscarPoloAdministradorPorId(Long id) {
        return poloAdministradorRepository.findById(id);
    }

    // Listar todos os relacionamentos Polo-Administrador
    public List<PoloAdministrador> listarPoloAdministradores() {
        return poloAdministradorRepository.findAll();
    }

    // Deletar relacionamento Polo-Administrador
    public void deletarPoloAdministrador(Long id) {
        poloAdministradorRepository.deleteById(id);
    }

}