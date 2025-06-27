package com.hotel.service;

import com.hotel.model.Hotel;
import com.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HotelService {

    @Autowired
    private HotelRepository repo;

    public List<Hotel> getAll() { return repo.findAll(); }
    public Optional<Hotel> getById(Integer id) { return repo.findById(id); }
    public Hotel save(Hotel h) { return repo.save(h); }
    public void delete(Integer id) { repo.deleteById(id); }
}
