package com.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario implements Serializable {
    @Id
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @NotBlank(message = "Debe de tener un nombre de usuario")
    @Column(name = "nombre_usuario", nullable = false)
    private String nombreUsuario;

    @NotBlank(message = "La contraseña no puede estar vacia")
    @Size(min = 5, message = "La contraseña debe mas de 5 caracteres")
    @Column(nullable = false)
    private String contrasena;

    @NotBlank(message = "Debe de tener un rol")
    @Column(nullable = false)
    private String rol;

}
