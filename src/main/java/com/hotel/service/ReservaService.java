// ReservaService.java
package com.hotel.service;

import com.hotel.model.Reserva;
import com.hotel.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository repo;

    public List<Reserva> getAll() { return repo.findAll(); }
    public Optional<Reserva> getById(Integer id) { return repo.findById(id); }
    public Reserva save(Reserva r) { return repo.save(r); }
    public void delete(Integer id) { repo.deleteById(id); }
}
