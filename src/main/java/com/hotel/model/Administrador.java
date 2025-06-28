package com.hotel.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Administrador implements Serializable {
    @Id
    @Column(name = "id_administrador")
    private Integer idAdministrador;

    @Column(name = "primer_nombre")
    private String primerNombre;

    @Column(name = "segundo_nombre")
    private String segundoNombre;

    @Column(name = "primer_apellido")
    private String primerApellido;

    @Column(name = "segundo_apellido")
    private String segundoApellido;

    private String correo;
    private String telefono;
}
