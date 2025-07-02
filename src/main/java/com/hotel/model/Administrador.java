package com.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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

    @Column(name = "primer_nombre", nullable = false)
    @NotBlank(message = "Se debe poner al menos el primer nombre")
    private String primerNombre;

    @Column(name = "segundo_nombre")
    private String segundoNombre;

    @NotBlank(message = "Se debe poner al menos el primer apellido")
    @Column(name = "primer_apellido", nullable = false)
    private String primerApellido;

    @Column(name = "segundo_apellido")
    private String segundoApellido;

    @NotBlank(message = "Se debe digitar un correo")
    @Email
    @Column(nullable = false)
    private String correo;

    @NotBlank(message = "Se debe digitar un telefono")
    @Column(nullable = false)
    private String telefono;
}
