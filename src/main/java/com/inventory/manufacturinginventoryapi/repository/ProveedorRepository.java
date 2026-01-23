package com.inventory.manufacturinginventoryapi.repository;

import com.inventory.manufacturinginventoryapi.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}
