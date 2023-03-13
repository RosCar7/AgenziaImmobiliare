package com.example.Agenzia.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;
import java.time.LocalDate;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Visita {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column
    private double durata;
    @Basic
    @Column
    private LocalDate data;
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
