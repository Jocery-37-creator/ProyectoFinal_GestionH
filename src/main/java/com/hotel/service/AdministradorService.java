package com.hotel.service;

import com.hotel.model.Administrador;
import com.hotel.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdministradorService {

    @Autowired
    private final AdministradorRepository repo;

    public AdministradorService(AdministradorRepository repo) {
        this.repo = repo;
    }

    public List<Administrador> getAll() { return repo.findAll(); }
    public Optional<Administrador> getById(Integer id) { return repo.findById(id); }
    public Administrador save(Administrador a) { return repo.save(a); }
    public void delete(Integer id) { repo.deleteById(id); }
}
