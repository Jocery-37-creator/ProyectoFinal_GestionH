package com.hotel.service;

import com.hotel.model.Pago;
import com.hotel.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class  PagoService {

    @Autowired
    private PagoRepository repo;

    public List<Pago> getAll() { return repo.findAll(); }
    public Optional<Pago> getById(Integer id) { return repo.findById(id); }
    public Pago save(Pago p) { return repo.save(p); }
    public void delete(Integer id) { repo.deleteById(id); }
}
