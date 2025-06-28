package com.hotel.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable {
    @Id
    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(name = "primer_nombre", nullable = false)
    private String primerNombre;

    @Column(name = "segundo_nombre")
    private String segundoNombre;

    @Column(name = "primer_apellido", nullable = false)
    private String primerApellido;

    @Column(name = "segundo_apellido")
    private String segundoApellido;

    @Column(nullable = false, unique = true)
    private Integer cedula;

    @Column(nullable = false)
    private String direccion;
}
