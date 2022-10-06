package com.example.examen_PaolaCriollo.service;

import com.example.examen_PaolaCriollo.model.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> findByAll();

    Cliente crear(Cliente cliente);

    Cliente findById(Long id);

    void delete(Long id);
}
