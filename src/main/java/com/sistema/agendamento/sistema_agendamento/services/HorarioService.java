package com.sistema.agendamento.sistema_agendamento.services;

import com.sistema.agendamento.sistema_agendamento.models.Horario;
import com.sistema.agendamento.sistema_agendamento.repositories.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    // Salvar ou atualizar um horário
    public Horario salvarHorario(Horario horario) {
        return horarioRepository.save(horario);
    }

    // Buscar um horário por ID
    public Optional<Horario> buscarHorarioPorId(Long id) {
        return horarioRepository.findById(id);
    }

    // Listar todos os horários
    public List<Horario> listarHorarios() {
        return horarioRepository.findAll();
    }

    // Deletar um horário
    public void deletarHorario(Long id) {
        horarioRepository.deleteById(id);
    }
    
}