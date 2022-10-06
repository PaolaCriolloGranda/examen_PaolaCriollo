package com.example.examen_PaolaCriollo.service;

import com.example.examen_PaolaCriollo.model.Factura;

import java.util.List;

public interface FacturaService {
    List<Factura> findByAll();

    Factura crear(Factura factura);

    Factura findById(Long id);

    void delete(Long id);
}

