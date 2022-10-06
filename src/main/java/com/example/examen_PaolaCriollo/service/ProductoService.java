package com.example.examen_PaolaCriollo.service;

import com.example.examen_PaolaCriollo.model.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> findByAll();

    Producto crear(Producto producto);

    Producto findById(Long id);

    void delete(Long id);
}
