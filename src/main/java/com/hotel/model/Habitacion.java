package com.hotel.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Habitacion implements Serializable {
    @Id
    @Column(name = "id_habitacion")
    private Integer idHabitacion;

    @Column(name = "numero_habitacion", nullable = false)
    private Integer numeroHabitacion;

    @Column(name = "precio_dia")
    private Integer precioDia;

    private Boolean disponible;
}
