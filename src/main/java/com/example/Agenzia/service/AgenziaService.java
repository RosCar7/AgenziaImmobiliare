package com.example.Agenzia.service;

import com.example.Agenzia.entity.Agenzia;
import com.example.Agenzia.entity.Cliente;
import com.example.Agenzia.repository.AgenziaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgenziaService {
    @Autowired
    private AgenziaRepository agenziaRepository;

    public Optional<Agenzia> findById(Long id) {
        return agenziaRepository.findById(id);
    }

    public Agenzia insertAgenzia(Agenzia agenzia) {
        return agenziaRepository.save(agenzia);

    }

    public Agenzia save(Agenzia agenzia) {
        return agenziaRepository.save(agenzia);
    }

    public void delete(Agenzia agenzia) {
        agenziaRepository.delete(agenzia);
    }
}
