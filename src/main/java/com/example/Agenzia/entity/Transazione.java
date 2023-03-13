package com.example.Agenzia.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column
    private double importo;
    @Basic
    @Column
    private LocalDate data;
    @Basic
    @Column
    private String descrizione;
    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "idProprieta", nullable = false)
    private Proprieta proprieta;
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
