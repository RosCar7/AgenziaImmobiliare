package com.example.Agenzia.dto;
import lombok.Data;
import java.time.LocalDate;

@Data
public class VisitaAgenziaDTO {

    private String nomeAgenzia, nomeCliente;
    private LocalDate data;
}