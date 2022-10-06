package com.example.examen_PaolaCriollo.controller;

import com.example.examen_PaolaCriollo.model.Cliente;
import com.example.examen_PaolaCriollo.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
    @RestController
    @RequestMapping("/cliente")
    public class ClienteController {
        @Autowired
        ClienteServiceImpl clienteS;

        @GetMapping("/listar")
        public ResponseEntity<List<Cliente>> listar() {
            return new ResponseEntity<>(clienteS.findByAll(), HttpStatus.OK);
        }

        @PostMapping("/crear")
        public ResponseEntity<Cliente> crear(@RequestBody Cliente c) {

            return new ResponseEntity<>(clienteS.crear(c), HttpStatus.CREATED);
        }

        @DeleteMapping("/eliminar/{id}")
        public ResponseEntity<Cliente> eliminar(@PathVariable Long id) {
            clienteS.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @PutMapping("/actualizar/{id}")
        public ResponseEntity<Cliente> actualizar(@PathVariable Long id, @RequestBody Cliente c) {
            Cliente cliente = clienteS.findById(id);
            if (cliente == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                try {
                    cliente.setNombre(c.getNombre());
                    cliente.setApellido(c.getApellido());
                    cliente.setTelefono(c.getTelefono());
                    cliente.setDni(c.getDni());
                    return new ResponseEntity<>(clienteS.crear(c), HttpStatus.CREATED);
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        }
    }


