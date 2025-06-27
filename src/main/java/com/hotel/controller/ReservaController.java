// ReservaController.java
package com.hotel.controller;

import com.hotel.model.Reserva;
import com.hotel.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService service;

    @GetMapping
    public List<Reserva> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getById(@PathVariable Integer id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reserva> create(@RequestBody Reserva r) {
        return ResponseEntity.ok(service.save(r));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> update(@PathVariable Integer id, @RequestBody Reserva r) {
        if (!service.getById(id).isPresent()) return ResponseEntity.notFound().build();
        r.setIdReserva(id);
        return ResponseEntity.ok(service.save(r));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!service.getById(id).isPresent()) return ResponseEntity.notFound().build();
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
