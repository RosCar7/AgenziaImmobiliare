package com.example.Agenzia.repository;

import com.example.Agenzia.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository <Cliente, Long> {





}
