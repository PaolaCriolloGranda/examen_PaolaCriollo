package com.example.examen_PaolaCriollo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "factura")
@Data
@AllArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "id_cliente")
    private Long id_cliente;
    @Column(name = "num_factura")
    private Long num_factura;
    @Column(name = "fecha")
    private Date fecha;

    public Factura() {

    }
}
