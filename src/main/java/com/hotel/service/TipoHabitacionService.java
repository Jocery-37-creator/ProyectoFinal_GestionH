package com.hotel.service;

import com.hotel.model.TipoHabitacion;
import com.hotel.repository.TipoHabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TipoHabitacionService {

    @Autowired
    private final TipoHabitacionRepository repo;

    public TipoHabitacionService(TipoHabitacionRepository repo) {
        this.repo = repo;
    }

    public List<TipoHabitacion> getAll() { return repo.findAll(); }
    public Optional<TipoHabitacion> getById(Integer id) { return repo.findById(id); }
    public TipoHabitacion save(TipoHabitacion t) { return repo.save(t); }
    public void delete(Integer id) { repo.deleteById(id); }
}
