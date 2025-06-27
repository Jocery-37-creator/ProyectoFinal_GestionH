package com.hotel.controller;

import com.hotel.model.Factura;
import com.hotel.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private FacturaService service;

    @GetMapping
    public List<Factura> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> getById(@PathVariable Integer id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Factura> create(@RequestBody Factura f) {
        return ResponseEntity.ok(service.save(f));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Factura> update(@PathVariable Integer id, @RequestBody Factura f) {
        if (!service.getById(id).isPresent()) return ResponseEntity.notFound().build();
        f.setIdFactura(id);
        return ResponseEntity.ok(service.save(f));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!service.getById(id).isPresent()) return ResponseEntity.notFound().build();
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
