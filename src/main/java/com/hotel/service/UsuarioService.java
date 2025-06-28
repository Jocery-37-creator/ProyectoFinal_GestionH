package com.hotel.service;

import com.hotel.model.Empleado;
import com.hotel.model.Usuario;
import com.hotel.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }
    public Usuario getById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }
    public Usuario save(Usuario e) {
        return usuarioRepository.save(e);
    }
    public void delete(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
