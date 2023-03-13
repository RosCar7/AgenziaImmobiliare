package com.example.Agenzia.service;

import com.example.Agenzia.entity.Transazione;
import com.example.Agenzia.repository.TransazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransazioneService {
    @Autowired
    TransazioneRepository transazioneRepository;


    public Optional<Transazione> findById(Long id) {
        return transazioneRepository.findById(id);
    }

    public Transazione insertTransazione(Transazione transazione) {
        return transazioneRepository.save(transazione);
    }

    public Transazione save(Transazione transazione) {
        return transazioneRepository.save(transazione);
    }

    public void delete(Transazione transazione) {
        transazioneRepository.delete(transazione);
    }
}

