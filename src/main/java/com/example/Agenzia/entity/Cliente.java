package com.example.Agenzia.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column
    private String nome;
    @Basic
    @Column
    private String cognome;
    @Basic
    @Column
    private String email;
    @Basic
    @Column
    private String telefono;
    @Basic
    @Column
    private String indirizzo;
    @CreatedDate
    @Column
    private Timestamp dataCreazione;
    @LastModifiedDate
    @Column
    private Timestamp dataUltimaModifica;
    @Version
    @Column
    private int versione;

}
