package com.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private String correo;
    @Column(nullable = false)
    private String telefono;
    @Column(nullable = false)
    private String primer_nombre;
    private String segundo_nombre;
    @Column(nullable = false)
    private String primer_apellido;
    private String segundo_apellido;

}
