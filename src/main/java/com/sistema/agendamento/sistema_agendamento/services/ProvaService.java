package com.sistema.agendamento.sistema_agendamento.services;

import com.sistema.agendamento.sistema_agendamento.models.Prova;
import com.sistema.agendamento.sistema_agendamento.repositories.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvaService {

    @Autowired
    private ProvaRepository provaRepository;

    // Salvar ou atualizar uma prova
    public Prova salvarProva(Prova prova) {
        return provaRepository.save(prova);
    }

    // Buscar uma prova por ID
    public Optional<Prova> buscarProvaPorId(Long id) {
        return provaRepository.findById(id);
    }

    // Listar todas as provas
    public List<Prova> listarProvas() {
        return provaRepository.findAll();
    }

    // Deletar uma prova
    public void deletarProva(Long id) {
        provaRepository.deleteById(id);
    }
}