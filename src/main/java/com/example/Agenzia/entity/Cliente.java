package com.example.Agenzia.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
    @Column(nullable = false)
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
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Visita> listaVisite = new ArrayList<>();
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)

    private List<Transazione> listaTransazioni = new ArrayList<>();
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
