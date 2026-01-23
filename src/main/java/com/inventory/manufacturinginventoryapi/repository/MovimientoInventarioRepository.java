package com.inventory.manufacturinginventoryapi.repository;

import com.inventory.manufacturinginventoryapi.model.MovimientoInventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoInventarioRepository extends JpaRepository <MovimientoInventario, Long> {
}
