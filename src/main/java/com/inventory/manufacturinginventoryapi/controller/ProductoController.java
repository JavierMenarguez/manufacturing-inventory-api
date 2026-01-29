package com.inventory.manufacturinginventoryapi.controller;

import com.inventory.manufacturinginventoryapi.model.Producto;
import com.inventory.manufacturinginventoryapi.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping
    public List<Producto> listar() {
        return productoService.listarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable Long id) {
        return productoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {
        Producto nuevo = productoService.guardar(producto);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Long id, @RequestBody Producto producto) {
        try {
            return ResponseEntity.ok(productoService.editar(id, producto));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            productoService.borrar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // /api/productos/5/proveedores/10
    @PostMapping("/{id}/proveedores/{proveedorId}")
    public ResponseEntity<Void> vincularProveedor(@PathVariable Long id, @PathVariable Long proveedorId) {
        productoService.vincularProveedor(id, proveedorId);
        return ResponseEntity.ok().build();
    }

    // /api/productos/5/proveedores/10
    @DeleteMapping("/{id}/proveedores/{proveedorId}")
    public ResponseEntity<Void> desvincularProveedor(@PathVariable Long id, @PathVariable Long proveedorId) {
        productoService.desvincularProveedor(id, proveedorId);
        return ResponseEntity.noContent().build();
    }
}
