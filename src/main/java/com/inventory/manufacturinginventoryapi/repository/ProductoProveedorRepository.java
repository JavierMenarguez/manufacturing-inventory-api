package com.inventory.manufacturinginventoryapi.repository;

import com.inventory.manufacturinginventoryapi.model.ProductoProveedor;
import com.inventory.manufacturinginventoryapi.model.ProductoProveedorID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoProveedorRepository extends JpaRepository<ProductoProveedor, ProductoProveedorID>{
    List<ProductoProveedor> findByIdProductoId(Long productoId);
}
