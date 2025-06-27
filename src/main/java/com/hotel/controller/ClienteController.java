// ClienteController.java
package com.hotel.controller;

import com.hotel.model.Cliente;
import com.hotel.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<Cliente> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Integer id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente c) {
        return ResponseEntity.ok(service.save(c));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody Cliente c) {
        if (!service.getById(id).isPresent()) return ResponseEntity.notFound().build();
        c.setIdCliente(id);
        return ResponseEntity.ok(service.save(c));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!service.getById(id).isPresent()) return ResponseEntity.notFound().build();
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
