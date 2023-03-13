package com.example.Agenzia.service;

import com.example.Agenzia.entity.Cliente;
import com.example.Agenzia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente insertCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void delete(Cliente cliente) {
        clienteRepository.delete(cliente);

    }
}
