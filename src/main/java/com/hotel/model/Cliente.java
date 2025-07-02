package com.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "Se debe poner al menos el primer nombre")
    @Column(name = "primer_nombre", nullable = false)
    private String primerNombre;

    @Column(name = "segundo_nombre")
    private String segundoNombre;

    @NotBlank(message = "Se debe poner al menos el primer apellido")
    @Column(name = "primer_apellido", nullable = false)
    private String primerApellido;

    @Column(name = "segundo_apellido")
    private String segundoApellido;

    @NotNull(message = "La cedula es obligatoria")
    @Column(nullable = false, unique = true)
    private Integer cedula;

    @NotBlank(message = "La direccion es obligatoria")
    @Column(nullable = false)
    private String direccion;
}
