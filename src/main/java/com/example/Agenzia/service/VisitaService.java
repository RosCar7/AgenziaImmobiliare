package com.example.Agenzia.service;

import com.example.Agenzia.entity.Cliente;
import com.example.Agenzia.entity.Visita;
import com.example.Agenzia.repository.TransazioneRepository;
import com.example.Agenzia.repository.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VisitaService {

    @Autowired
    private VisitaRepository visitaRepository;

    public Optional<Visita> findById(Long id) {
        return visitaRepository.findById(id);
    }

    public Visita insertVisita(Visita visita) {
        return visitaRepository.save(visita);
    }

    public Visita save(Visita visita) {
        return visitaRepository.save(visita);

    }

    public void delete(Visita visita) {
        visitaRepository.delete(visita);
    }

}
