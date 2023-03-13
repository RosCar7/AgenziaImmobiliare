package com.example.Agenzia.dto;
import lombok.Data;
import java.time.LocalDate;

@Data
public class TransazioneClienteDTO {

    private String nomeCliente;
    private String nomeAgenzia;
    private double importo;
    private LocalDate data;
}
