package com.example.examen_PaolaCriollo.service;

import com.example.examen_PaolaCriollo.model.Producto;
import com.example.examen_PaolaCriollo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductoServiceImpl  implements ProductoService{
    @Autowired
    ProductoRepository repository;

    @Override
    public List<Producto> findByAll() {
      return   repository.findAll();
    }

    @Override
    public Producto crear(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public Producto findById(Long id) {
         return repository.findById(id).orElse(new Producto());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
