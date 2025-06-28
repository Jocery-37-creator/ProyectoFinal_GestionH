// ClienteService.java
package com.hotel.service;

import com.hotel.model.Cliente;
import com.hotel.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClienteService {
    @Autowired
    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public List<Cliente> getAll() { return repo.findAll(); }
    public Optional<Cliente> getById(Integer id) { return repo.findById(id); }
    public Cliente save(Cliente c) { return repo.save(c); }
    public void delete(Integer id) { repo.deleteById(id); }
}
