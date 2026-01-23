package com.inventory.manufacturinginventoryapi.repository;


import com.inventory.manufacturinginventoryapi.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
