package com.hotel.controller;

import com.hotel.model.Pago;
import com.hotel.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private PagoService service;

    @GetMapping
    public List<Pago> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> getById(@PathVariable Integer id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pago> create(@RequestBody Pago p) {
        return ResponseEntity.ok(service.save(p));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pago> update(@PathVariable Integer id, @RequestBody Pago p) {
        if (!service.getById(id).isPresent()) return ResponseEntity.notFound().build();
        p.setIdPago(id);
        return ResponseEntity.ok(service.save(p));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!service.getById(id).isPresent()) return ResponseEntity.notFound().build();
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
