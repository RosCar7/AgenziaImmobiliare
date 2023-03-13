package com.example.Agenzia.dto;
import lombok.*;
import java.time.LocalDate;

@Data
public class VisitaClienteDTO {

    private String nomeAgenzia;
    private LocalDate data;
}