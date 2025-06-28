package com.hotel.service;

import com.hotel.model.Factura;
import com.hotel.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FacturaService {

    @Autowired
    private final FacturaRepository repo;

    public FacturaService(FacturaRepository repo) {
        this.repo = repo;
    }

    public List<Factura> getAll() { return repo.findAll(); }
    public Optional<Factura> getById(Integer id) { return repo.findById(id); }
    public Factura save(Factura f) { return repo.save(f); }
    public void delete(Integer id) { repo.deleteById(id); }
}
