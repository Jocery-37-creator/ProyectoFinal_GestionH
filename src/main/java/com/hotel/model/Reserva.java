package com.hotel.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
    @Id
    @Column(name = "id_reserva")
    private Integer idReserva;

    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_final")
    private LocalDateTime fechaFinal;

    @Column(name = "cantidad_dias")
    private Integer cantidadDias;

    private Boolean estado;

    @Column(name = "fecha_reserva")
    private LocalDateTime fechaReserva;

    @ManyToOne
    @JoinColumn(name = "fk_id_habitacion")
    private Habitacion habitacion;

    @ManyToOne
    @JoinColumn(name = "fk_id_cliente")
    private Cliente cliente;
}
