package com.example.Agenzia.service;

import com.example.Agenzia.entity.Cliente;
import com.example.Agenzia.entity.Proprieta;
import com.example.Agenzia.repository.ProprietaRepository;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class ProprietaService {
    @Autowired
    private ProprietaRepository proprietaRepository;


    public Optional<Proprieta> findById(Long id) {
        return proprietaRepository.findById(id);
    }

    public Proprieta insertProprieta(Proprieta proprieta) {
        return proprietaRepository.save(proprieta);
    }

    public Proprieta save(Proprieta proprieta) {
        return proprietaRepository.save(proprieta);
    }

    public void delete(Proprieta proprieta) {
        proprietaRepository.delete(proprieta);
    }
}

