package com.hotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
