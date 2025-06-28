package com.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.io.Serializable;

public class Usuario implements Serializable {
    @Id
    private Integer id_usuario;
    @Column(nullable = false)
    private String nombre_usuario;
    @Column(nullable = false)
    private String contrasena;
    private String rol;

    @OneToOne
    @JoinColumn(name="fk_id_cliente")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name="fk_id_empleado")
    private Empleado empleado;

    @OneToOne
    @JoinColumn(name="fk_id_administrador")
    private Administrador administrador;
}
