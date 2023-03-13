package com.example.Agenzia.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class ClienteDTO {

    private String nome, cognome, email;
    private int telefono;
}
