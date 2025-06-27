package com.hotel.controller;

import com.hotel.model.Administrador;
import com.hotel.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorService service;

    @GetMapping
    public List<Administrador> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Administrador> getById(@PathVariable Integer id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Administrador> create(@RequestBody Administrador a) {
        return ResponseEntity.ok(service.save(a));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrador> update(@PathVariable Integer id, @RequestBody Administrador a) {
        if (!service.getById(id).isPresent()) return ResponseEntity.notFound().build();
        a.setIdAdministrador(id);
        return ResponseEntity.ok(service.save(a));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!service.getById(id).isPresent()) return ResponseEntity.notFound().build();
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
