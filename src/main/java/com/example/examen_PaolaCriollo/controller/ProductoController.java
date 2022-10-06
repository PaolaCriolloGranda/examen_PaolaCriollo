package com.example.examen_PaolaCriollo.controller;

import com.example.examen_PaolaCriollo.model.Cliente;
import com.example.examen_PaolaCriollo.model.Producto;
import com.example.examen_PaolaCriollo.service.ClienteServiceImpl;
import com.example.examen_PaolaCriollo.service.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    ProductoServiceImpl productoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listar() {
        return new ResponseEntity<>(productoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Producto> crear(@RequestBody Producto c) {

        return new ResponseEntity<>(productoService.crear(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Producto> eliminar(@PathVariable Long id) {
        productoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Long id, @RequestBody Producto c) {
        Producto producto = productoService.findById(id);
        if (producto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                producto.setCod_producto(c.getCod_producto());
                producto.setCantidad(c.getCantidad());
                producto.setPrecio(c.getPrecio());

                return new ResponseEntity<>(productoService.crear(c), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
