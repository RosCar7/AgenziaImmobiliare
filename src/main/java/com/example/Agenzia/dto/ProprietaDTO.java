package com.example.Agenzia.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class ProprietaDTO {

    private String indirizzo, tipoDiProprieta;
    private double prezzo;
}
