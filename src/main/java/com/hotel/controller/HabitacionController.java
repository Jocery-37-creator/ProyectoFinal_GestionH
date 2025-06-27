// HabitacionController.java
package com.hotel.controller;

import com.hotel.model.Habitacion;
import com.hotel.service.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/habitaciones")
public class HabitacionController {

    @Autowired
    private HabitacionService service;

    @GetMapping
    public List<Habitacion> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Habitacion> getById(@PathVariable Integer id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Habitacion> create(@RequestBody Habitacion h) {
        return ResponseEntity.ok(service.save(h));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habitacion> update(@PathVariable Integer id, @RequestBody Habitacion h) {
        if (!service.getById(id).isPresent()) return ResponseEntity.notFound().build();
        h.setIdHabitacion(id);
        return ResponseEntity.ok(service.save(h));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!service.getById(id).isPresent()) return ResponseEntity.notFound().build();
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
