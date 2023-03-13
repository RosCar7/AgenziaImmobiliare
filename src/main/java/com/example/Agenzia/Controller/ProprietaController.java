package com.example.Agenzia.Controller;

import com.example.Agenzia.entity.Cliente;
import com.example.Agenzia.entity.Proprieta;
import com.example.Agenzia.service.ProprietaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Optional;

@RequestMapping
@RestController
public class ProprietaController {

    @Autowired
    private ProprietaService proprietaService;



    @GetMapping("/{id}")
    public ResponseEntity<Proprieta> getProprietaById(@PathVariable Long id){
        Optional<Proprieta> existingProprieta = proprietaService.findById(id);
        try {
            if(existingProprieta.isPresent()){
                return new ResponseEntity<>(existingProprieta.get(), HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping
    public ResponseEntity<Proprieta> insertProprieta(@RequestBody Proprieta proprieta){
        try {
            Proprieta d = proprietaService.insertProprieta(proprieta);
            if(d == null){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(d, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/{id}/{numeroDiStanze}/{tipoDiProprieta}/{prezzo}/{indirizzo}")
    public ResponseEntity<Proprieta> updateProprieta(@PathVariable Long id,
                                                 @PathVariable String tipoDiProprieta, @PathVariable int numeroDiStanze
           , @PathVariable String indirizzo, @PathVariable double prezzo){
        Optional<Proprieta> existingProprieta = proprietaService.findById(id);
        try {
            if(existingProprieta.isPresent()){
                Proprieta proprieta = existingProprieta.get();
                proprieta.setTipoDiProprieta(tipoDiProprieta);
                proprieta.setNumeroDiStanze(numeroDiStanze);
                proprieta.setIndirizzo(indirizzo);
                proprieta.setPrezzo(prezzo);
                proprieta.setDataUltimaModifica(new Timestamp(System.currentTimeMillis()));
                proprieta.setVersione(proprieta.getVersione() + 1);
                Proprieta updatedProprieta= proprietaService.save(proprieta);
                return new ResponseEntity<>(updatedProprieta, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProprieta(@PathVariable Long id){
        Optional<Proprieta> existingProprieta = proprietaService.findById(id);
        try {
            if(existingProprieta.isPresent()){
                proprietaService.delete(existingProprieta.get());
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
