// HabitacionService.java
package com.hotel.service;

import com.hotel.model.Habitacion;
import com.hotel.repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HabitacionService {
    @Autowired
    private HabitacionRepository repo;

    public List<Habitacion> getAll() { return repo.findAll(); }
    public Optional<Habitacion> getById(Integer id) { return repo.findById(id); }
    public Habitacion save(Habitacion h) { return repo.save(h); }
    public void delete(Integer id) { repo.deleteById(id); }
}
