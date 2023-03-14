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
public class Proprieta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;
    @Basic
    @Column
    private String indirizzo;
    @Basic
    @Column
    private String tipo;
    @Basic
    @Column
    private int stanze;
    @Basic
    @Column
    private double prezzo;
    @ManyToOne
    @JoinColumn(name = "idAgenzia", nullable = true)
    private Agenzia agenzia;
    @OneToMany(mappedBy = "proprieta", fetch = FetchType.LAZY)
    private List<Transazione> listaTransazioni = new ArrayList<>();
    @OneToMany(mappedBy = "proprieta", fetch = FetchType.LAZY)
    private List<Visita> listaVisite = new ArrayList<>();

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
