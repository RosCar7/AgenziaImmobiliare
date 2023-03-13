package com.example.Agenzia.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class AgenziaDTO {

    private String nome, indirizzo;
    private int telefono;
}
