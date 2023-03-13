package com.example.Agenzia.repository;

import com.example.Agenzia.entity.Transazione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransazioneRepository extends JpaRepository <Transazione, Long> {
}
