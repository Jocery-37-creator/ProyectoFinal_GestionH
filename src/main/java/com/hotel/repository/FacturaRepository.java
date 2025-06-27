package com.hotel.repository;

import com.hotel.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {}
