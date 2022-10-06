package com.example.examen_PaolaCriollo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "producto")
@Data
@AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_factura")
    private Long id_factura;

    @Column(name = "cod_producto")
    private String cod_producto;

    @Column(name = "cantidad")
    private String cantidad;

    @Column(name = "precio")
    private double precio;

    public Producto() {

    }
}
