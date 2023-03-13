package com.example.Agenzia.dto;
import lombok.Data;
import java.time.LocalDate;

@Data
public class TransazioneAgenziaDTO {

    private String nomeAgenzia, nomeCliente;
    private double importo;
    private LocalDate data;
}
