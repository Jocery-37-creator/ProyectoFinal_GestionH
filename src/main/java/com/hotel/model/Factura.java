package com.hotel.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura implements Serializable {
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
    private Integer fechaEmision;

    @Column(name = "valor_total")
    private Integer valorTotal;
}
