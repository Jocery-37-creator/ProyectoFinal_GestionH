package com.hotel.service;

import com.hotel.model.Empleado;
import com.hotel.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository){
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> getAll() {
        return empleadoRepository.findAll();
    }
    public Optional<Empleado> getById(Integer id) {
        return empleadoRepository.findById(id);
    }
    public Empleado save(Empleado e) {
        return empleadoRepository.save(e);
    }
    public void delete(Integer id) {
        empleadoRepository.deleteById(id);
    }


}
