package com.hotel.controller;

import com.hotel.model.Hotel;
import com.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/hoteles")
public class HotelController {

    @Autowired
    private HotelService service;

    @GetMapping
    public List<Hotel> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getById(@PathVariable Integer id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Hotel> create(@RequestBody Hotel h) {
        return ResponseEntity.ok(service.save(h));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> update(@PathVariable Integer id, @RequestBody Hotel h) {
        if (!service.getById(id).isPresent()) return ResponseEntity.notFound().build();
        h.setIdHotel(id);
        return ResponseEntity.ok(service.save(h));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!service.getById(id).isPresent()) return ResponseEntity.notFound().build();
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
