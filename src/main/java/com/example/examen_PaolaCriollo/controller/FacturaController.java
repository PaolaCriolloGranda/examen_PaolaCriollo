package com.example.examen_PaolaCriollo.controller;

import com.example.examen_PaolaCriollo.model.Factura;
import com.example.examen_PaolaCriollo.model.Producto;
import com.example.examen_PaolaCriollo.service.FacturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factura")
public class FacturaController {
    @Autowired
    FacturaServiceImpl facturaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Factura>> listar() {
        return new ResponseEntity<>(facturaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Factura> crear(@RequestBody Factura c) {

        return new ResponseEntity<>(facturaService.crear(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Producto> eliminar(@PathVariable Long id) {
        facturaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Factura> actualizar(@PathVariable Long id, @RequestBody Factura c) {
        Factura factura = facturaService.findById(id);
        if (factura == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                factura.setNum_factura(c.getNum_factura());
                factura.setFecha(c.getFecha());
                return new ResponseEntity<>(facturaService.crear(c), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
