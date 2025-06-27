package com.hotel.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoHabitacion {
    @Id
    @Column(name = "id_tipo_habitacion")
    private Integer idTipoHabitacion;

    @ManyToOne
    @JoinColumn(name = "fk_id_hotel")
    private Hotel hotel;

    private String nombre;
    private Integer cantidad;
}
