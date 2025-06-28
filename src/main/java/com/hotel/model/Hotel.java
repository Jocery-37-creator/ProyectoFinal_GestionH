package com.hotel.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel implements Serializable {
    @Id
    @Column(name = "id_hotel")
    private Integer idHotel;

    private String nombre;
    private String ciudad;
    private String telefono;
    private String correo;
    private String direccion;
}
