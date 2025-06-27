package com.hotel.controller;

import com.hotel.model.TipoHabitacion;
import com.hotel.service.TipoHabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/tipos-habitacion")
public class TipoHabitacionController {

    @Autowired
    private TipoHabitacionService service;

    @GetMapping
    public List<TipoHabitacion> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<TipoHabitacion> getById(@PathVariable Integer id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoHabitacion> create(@RequestBody TipoHabitacion t) {
        return ResponseEntity.ok(service.save(t));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoHabitacion> update(@PathVariable Integer id, @RequestBody TipoHabitacion t) {
        if (!service.getById(id).isPresent()) return ResponseEntity.notFound().build();
        t.setIdTipoHabitacion(id);
        return ResponseEntity.ok(service.save(t));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!service.getById(id).isPresent()) return ResponseEntity.notFound().build();
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
