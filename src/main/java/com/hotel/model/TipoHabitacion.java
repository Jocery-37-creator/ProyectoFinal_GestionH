package com.hotel.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoHabitacion implements Serializable {
    @Id
    @Column(name = "id_tipo_habitacion")
    private Integer idTipoHabitacion;

    @ManyToOne
    @JoinColumn(name = "fk_id_hotel")
    private Hotel hotel;

    private String nombre;
    private Integer cantidad;
}
