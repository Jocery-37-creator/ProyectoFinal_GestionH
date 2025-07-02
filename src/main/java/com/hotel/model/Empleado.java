package com.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado implements Serializable {
    @Id
    private Integer id_empleado;

    @Email
    @NotBlank(message = "Se debe digitar un correo")
    private String correo;

    @NotBlank(message = "Se debe digitar un telefono")
    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    @NotBlank(message = "Se debe poner al menos el primer nombre")
    private String primer_nombre;

    private String segundo_nombre;

    @NotBlank(message = "Se debe poner al menos el primer apellido")
    @Column(nullable = false)
    private String primer_apellido;

    private String segundo_apellido;

}
