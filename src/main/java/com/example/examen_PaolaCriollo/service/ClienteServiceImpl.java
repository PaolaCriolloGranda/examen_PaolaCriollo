package com.example.examen_PaolaCriollo.service;

import com.example.examen_PaolaCriollo.model.Cliente;
import com.example.examen_PaolaCriollo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    ClienteRepository repository;
    @Override
    public List<Cliente> findByAll() {
        return repository.findAll();
    }

    @Override
    public Cliente crear(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public Cliente findById(Long id) {
        return repository.findById(id).orElse(new Cliente());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
