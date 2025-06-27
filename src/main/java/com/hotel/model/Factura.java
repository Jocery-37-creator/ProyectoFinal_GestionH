package com.hotel.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura {
    @Id
    @Column(name = "id_factura")
    private Integer idFactura;

    @ManyToOne
    @JoinColumn(name = "fk_id_reserva")
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "fk_id_pago")
    private Pago pago;

    @Column(name = "fecha_emision")
    private Integer fechaEmision; // Puedes cambiarlo a LocalDate si prefieres

    @Column(name = "valor_total")
    private Integer valorTotal;
}
