package com.hotel.repository;

import org.springframework.stereotype.Repository;
import com.hotel.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
