package com.example.Agenzia.Controller;

import com.example.Agenzia.entity.Cliente;
import com.example.Agenzia.entity.Visita;
import com.example.Agenzia.service.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Optional;

@RequestMapping("/visita")
@RestController
public class VisitaController {
    @Autowired
    private VisitaService visitaService;


    @GetMapping("/{id}")
    public ResponseEntity<Visita> getVisitaById(@PathVariable Long id){
        Optional<Visita> existingvVisita = visitaService.findById(id);
        try {
            if(existingvVisita.isPresent()){
                return new ResponseEntity<>(existingvVisita.get(), HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Visita> insertVisita(@RequestBody Visita visita){
        try {
            Visita d = visitaService.insertVisita(visita);
            if(d == null){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(d, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}/{durata}/{data}")
    public ResponseEntity<Visita> updateVisita(@PathVariable Long id,
                                               @PathVariable int durata, @PathVariable LocalDate data){
        Optional<Visita> existingVisita = visitaService.findById(id);
        try {
            if(existingVisita.isPresent()){
                Visita visita = existingVisita.get();
                visita.setData(data);
                visita.setDurata(durata);
                visita.setDataUltimaModifica(new Timestamp(System.currentTimeMillis()));
                visita.setVersione(visita.getVersione() + 1);
                Visita updatedVisita = visitaService.save(visita);
                return new ResponseEntity<>(updatedVisita, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisita(@PathVariable Long id){
        Optional<Visita> existingVisita = visitaService.findById(id);
        try {
            if(existingVisita.isPresent()){
                visitaService.delete(existingVisita.get());
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
