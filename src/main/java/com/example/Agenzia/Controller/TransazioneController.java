package com.example.Agenzia.Controller;

import com.example.Agenzia.entity.Cliente;
import com.example.Agenzia.entity.Transazione;
import com.example.Agenzia.service.TransazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Optional;

@RequestMapping
@RestController
public class TransazioneController {
    @Autowired
    TransazioneService transazioneService;

    @GetMapping("/{id}")
    public ResponseEntity<Transazione> getTransazioneById(@PathVariable Long id){
        Optional<Transazione> existingTransazione = transazioneService.findById(id);
        try {
            if(existingTransazione.isPresent()){
                return new ResponseEntity<>(existingTransazione.get(), HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping
    public ResponseEntity<Transazione> insertTransazione(@RequestBody Transazione transazione){
        try {
            Transazione d = transazioneService.insertTransazione(transazione);
            if(d == null){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(d, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{importo}/{data}/{descrizione}")
    public ResponseEntity<Transazione> updateTransazione(@PathVariable Long id,
                                                 @PathVariable String descrizione, @PathVariable LocalDate data, @PathVariable double importo){
        Optional<Transazione> existingTransazione = transazioneService.findById(id);
        try {
            if(existingTransazione.isPresent()){
                Transazione transazione = existingTransazione.get();
                transazione.setData(data);
                transazione.setImporto(importo);
                transazione.setDescrizione(descrizione);
                transazione.setDataUltimaModifica(new Timestamp(System.currentTimeMillis()));
                transazione.setVersione(transazione.getVersione() + 1);
                Transazione updatedTransazione = transazioneService.save(transazione);
                return new ResponseEntity<>(updatedTransazione, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransazione(@PathVariable Long id){
        Optional<Transazione> existingTransazione = transazioneService.findById(id);
        try {
            if(existingTransazione.isPresent()){
                transazioneService.delete(existingTransazione.get());
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
