package com.example.Agenzia.Controller;

import com.example.Agenzia.dto.ClienteDTO;
import com.example.Agenzia.entity.Cliente;
import com.example.Agenzia.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequestMapping("/cliente")
@RestController

public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    private Modelmapper mapper;

    /*@GetMapping
    public ResponseEntity<List<ClienteDTO>> getAllClienti() {
        try {
            List<Cliente> clienteList = clienteService.findAll();
            List<ClienteDTO> clienteDTOList = new ArrayList<>();
            for (Cliente d : clienteList) {
                ClienteDTO clienteDTO = Collections.singletonList(mapper.map(d, ClienteDTO.class));
                clienteDTOList.add(clienteDTO);
            }
            if (clienteList.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(clienteDTOList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/




    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClienti(){
        try {
            List<Cliente> clienteList = clienteService.findAll();
            if(clienteList.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(clienteList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id){
        Optional<Cliente> existingCliente = clienteService.findById(id);
        try {
            if(existingCliente.isPresent()){
                return new ResponseEntity<>(existingCliente.get(), HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Cliente> insertCliente(@RequestBody Cliente cliente){
        try {
            Cliente d = clienteService.insertCliente(cliente);
            if(d == null){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(d, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}/{nome}/{cognome}/{email}/{telefono}/{indirizzo}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id,
                                                       @PathVariable String nome, @PathVariable String cognome
                                                        , @PathVariable String email, @PathVariable String telefono, @PathVariable String indirizzo){
        Optional<Cliente> existingCliente = clienteService.findById(id);
        try {
            if(existingCliente.isPresent()){
                Cliente cliente = existingCliente.get();
                cliente.setNome(nome);
                cliente.setCognome(cognome);
                cliente.setTelefono(telefono);
                cliente.setEmail(email);
                cliente.setIndirizzo(indirizzo);
                cliente.setDataUltimaModifica(new Timestamp(System.currentTimeMillis()));
                cliente.setVersione(cliente.getVersione() + 1);
                Cliente updatedDipendente = clienteService.save(cliente);
                return new ResponseEntity<>(updatedDipendente, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id){
        Optional<Cliente> existingCliente = clienteService.findById(id);
        try {
            if(existingCliente.isPresent()){
                clienteService.delete(existingCliente.get());
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
