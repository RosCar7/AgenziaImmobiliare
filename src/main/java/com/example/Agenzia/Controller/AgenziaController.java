package com.example.Agenzia.Controller;

import com.example.Agenzia.entity.Agenzia;
import com.example.Agenzia.entity.Cliente;
import com.example.Agenzia.service.AgenziaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Optional;

@RequestMapping("/agenzia")
@RestController

public class AgenziaController {

    @Autowired
    private AgenziaService agenziaService;


    @GetMapping("/{alemanno}")
    public ResponseEntity<Agenzia> getAgenziaById(@PathVariable Long alemanno){
        Optional<Agenzia> existingAgenzia = agenziaService.findById(alemanno);
        try {
            if(existingAgenzia.isPresent()){
                return new ResponseEntity<>(existingAgenzia.get(), HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping
    public ResponseEntity<Agenzia> insertAgenzia(@RequestBody Agenzia agenzia){
        try {
            Agenzia a = agenziaService.insertAgenzia(agenzia);
            if(a == null){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(a, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id_agenzia}/{nome}/{telefono}/{indirizzo}")
    public ResponseEntity<Agenzia> updateAgenzia(@PathVariable Long id_agenzia,
                                                 @PathVariable String nome, @PathVariable String telefono, @PathVariable String indirizzo){
        Optional<Agenzia> existingAgenzia = agenziaService.findById(id_agenzia);
        try {
            if(existingAgenzia.isPresent()){
                Agenzia agenzia = existingAgenzia.get();
                agenzia.setNome(nome);
                agenzia.setTelefono(telefono);
                agenzia.setIndirizzo(indirizzo);
                agenzia.setDataUltimaModifica(new Timestamp(System.currentTimeMillis()));
                agenzia.setVersione(agenzia.getVersione() + 1);
                Agenzia updatedAgenzia = agenziaService.save(agenzia);
                return new ResponseEntity<>(updatedAgenzia, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id_agenzia}")
    public ResponseEntity<Void> deleteAgenzia(@PathVariable Long id_agenzia){
        Optional<Agenzia> existingAgenzia = agenziaService.findById(id_agenzia);
        try {
            if(existingAgenzia.isPresent()){
                agenziaService.delete(existingAgenzia.get());
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
