package com.example.examen_PaolaCriollo.repository;
import com.example.examen_PaolaCriollo.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository  extends JpaRepository<Producto, Long> {
}
