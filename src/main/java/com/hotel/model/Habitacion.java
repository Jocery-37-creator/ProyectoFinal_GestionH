package com.hotel.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="habitacion")
public class Habitacion implements Serializable {
    @Id
    @Column(name = "id_habitacion")
    private Integer idHabitacion;

    @Column(name = "numero_habitacion", nullable = false)
    private Integer numeroHabitacion;

    @ManyToOne
    @JoinColumn(name = "fk_id_tipo_habitacion", nullable = false)
    private TipoHabitacion tipoHabitacion;

    @ManyToOne
    @JoinColumn(name = "fk_id_hotel", nullable = false)
    private Hotel hotel;

    @Column(name = "precio_dia")
    private Integer precioDia;

    private Boolean disponible;
}
