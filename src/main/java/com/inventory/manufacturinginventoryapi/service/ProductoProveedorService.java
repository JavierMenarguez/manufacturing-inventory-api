package com.inventory.manufacturinginventoryapi.service;

import com.inventory.manufacturinginventoryapi.model.ProductoProveedor;
import com.inventory.manufacturinginventoryapi.repository.ProductoProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoProveedorService {

    private final ProductoProveedorRepository repository;

    /**
     * Obtener los vinculos entre productos y proveedores
     * @return Devuelve una lista de ProductoProveedor
     */
    public List<ProductoProveedor> listarTodo() {
        return repository.findAll();
    }

    /**
     * Busca todos los proveedores asociados a un producto filtrado por ID
     * @param productoId ID del producto a encontrar sus proveedores
     * @return Devuelve la relacion producto-proveedor asociado a un producro
     */
    public List<ProductoProveedor> listarPorProducto(Long productoId) {
        return repository.findByIdProductoId(productoId);
    }

    /**
     * Registra una nueva relación producto-proveedor
     */
    public ProductoProveedor vincular(ProductoProveedor pp) {
        return repository.save(pp);
    }
}
