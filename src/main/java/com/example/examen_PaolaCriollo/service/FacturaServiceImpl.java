package com.example.examen_PaolaCriollo.service;

import com.example.examen_PaolaCriollo.model.Factura;
import com.example.examen_PaolaCriollo.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImpl implements FacturaService{
    @Autowired
    FacturaRepository repository;
    @Override
    public List<Factura> findByAll() {
        return repository.findAll();
    }

    @Override
    public Factura crear(Factura factura) {
        return repository.save(factura);
    }

    @Override
    public Factura findById(Long id) {
        return repository.findById(id).orElse(new Factura());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
