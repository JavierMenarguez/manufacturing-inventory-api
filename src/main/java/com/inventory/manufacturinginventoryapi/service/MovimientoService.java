package com.inventory.manufacturinginventoryapi.service;

import com.inventory.manufacturinginventoryapi.model.MovimientoInventario;
import com.inventory.manufacturinginventoryapi.model.Producto;
import com.inventory.manufacturinginventoryapi.repository.MovimientoInventarioRepository;
import com.inventory.manufacturinginventoryapi.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovimientoService {

    private final MovimientoInventarioRepository movimientoRepository;
    private final ProductoRepository productoRepository;

    /**
     * Registra un movimiento nuevo en el inventario
     * @param movimiento Movimiento a crear en BD
     * @return Devuele el movimiento que fue creado
     */
    @Transactional
    public MovimientoInventario registrar(MovimientoInventario movimiento) {
        // Buscar el producto afectado
        Producto producto = productoRepository.findById(movimiento.getProducto().getId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Calcular el nuevo stock
        BigDecimal cantidad = movimiento.getCantidad();
        if ("SALIDA".equalsIgnoreCase(movimiento.getTipoMovimiento())) {
            // Validar si hay suficiente stock
            if (producto.getExistencias().compareTo(cantidad) < 0) {
                throw new RuntimeException("Stock insuficiente para la salida");
            }
            producto.setExistencias(producto.getExistencias().subtract(cantidad));
        } else if ("ENTRADA".equalsIgnoreCase(movimiento.getTipoMovimiento())) {
            producto.setExistencias(producto.getExistencias().add(cantidad));
        }

        // Guardar el producto actualizado y el movimiento
        productoRepository.save(producto);
        return movimientoRepository.save(movimiento);
    }

    /**
     * Obtener la lista de movimientos en el inventario
     * @return Devuelve la lista de movimientos de inventario
     */
    public List<MovimientoInventario> listarTodo() {
        return movimientoRepository.findAll();
    }
}
