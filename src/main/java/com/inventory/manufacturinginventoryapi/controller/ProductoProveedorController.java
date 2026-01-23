package com.inventory.manufacturinginventoryapi.controller;

import com.inventory.manufacturinginventoryapi.model.ProductoProveedor;
import com.inventory.manufacturinginventoryapi.service.ProductoProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto-proveedor")
@RequiredArgsConstructor
public class ProductoProveedorController {

    private final ProductoProveedorService service;

    // Obtener todos los vínculos (quién le vende a quién)
    @GetMapping
    public List<ProductoProveedor> listarTodo() {
        return service.listarTodo();
    }

    // Buscar proveedores específicos para un producto
    @GetMapping("/producto/{productoId}")
    public List<ProductoProveedor> listarPorProducto(@PathVariable Long productoId) {
        return service.listarPorProducto(productoId);
    }

    // Vincular un producto con un proveedor (y ponerle precio/tiempo entrega)
    @PostMapping
    public ProductoProveedor vincular(@RequestBody ProductoProveedor productoProveedor) {
        return service.vincular(productoProveedor);
    }
}
