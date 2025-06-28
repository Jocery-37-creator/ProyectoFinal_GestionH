package com.hotel.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tipo_habitacion")
public class TipoHabitacion implements Serializable {
    @Id
    @Column(name = "id_tipo_habitacion")
    private Integer idTipoHabitacion;

    //No deberia de existir esta llave foranea, no tiene sentido.
    @ManyToOne
    @JoinColumn(name = "fk_id_hotel")
    private Hotel hotel;

    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private Integer cantidad;
}
