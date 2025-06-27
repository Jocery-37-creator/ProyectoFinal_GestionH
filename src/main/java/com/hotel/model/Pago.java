package com.hotel.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pago {
    @Id
    @Column(name = "id_pago")
    private Integer idPago;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "fk_id_reserva")
    private Reserva reserva;

    @Column(name = "metodo_pago")
    private String metodoPago;

    @Column(name = "pago_total")
    private Integer pagoTotal;
}
