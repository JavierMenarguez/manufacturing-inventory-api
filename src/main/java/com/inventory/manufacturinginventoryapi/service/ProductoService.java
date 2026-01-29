package com.inventory.manufacturinginventoryapi.service;

import com.inventory.manufacturinginventoryapi.model.Producto;
import com.inventory.manufacturinginventoryapi.model.Proveedor;
import com.inventory.manufacturinginventoryapi.repository.ProductoRepository;
import com.inventory.manufacturinginventoryapi.repository.ProveedorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final ProveedorRepository proveedorRepository;

    /**
     * Obtener la lista completa de productos
     * @return Devuelve la lista completa
     */
    public List<Producto> listarTodo() {
        return productoRepository.findAll();
    }

    /**
     * Buscar producto por ID
     * @param id ID del producto a buscar
     * @return Devuelve el producto encontrado
     */
    public Optional<Producto> buscarPorId(Long id) {
        return productoRepository.findById(id);
    }

    /**
     * Guardar nuevo procucto
     * @param producto Producto a guardar
     * @return Devuelve el producto guardado
     */
    @Transactional
    public Producto guardar(Producto producto) {
        if (producto.getSku() != null) {
            producto.setSku(producto.getSku().toUpperCase());
        }
        return productoRepository.save(producto);
    }

    /**
     * Actualizar un producto de BD
     * @param id ID del producto a modificar
     * @param detalles Datos a sobrescribir
     * @return Devuelve el producto actualizado
     */
    @Transactional
    public Producto editar(Long id, Producto detalles) {
        return productoRepository.findById(id).map(prod -> {
            prod.setNombre(detalles.getNombre());
            prod.setDescripcion(detalles.getDescripcion());
            prod.setPrecioVenta(detalles.getPrecioVenta());
            prod.setExistencias(detalles.getExistencias());
            prod.setPuntoReorden(detalles.getPuntoReorden());
            prod.setUnidadMedida(detalles.getUnidadMedida());
            prod.setTipoProducto(detalles.getTipoProducto());
            prod.setActivo(detalles.getActivo());
            prod.setCategoria(detalles.getCategoria());
            return productoRepository.save(prod);
        }).orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
    }

    /**
     * Eliminar producto
     * @param id ID del producto a eliminar
     */
    @Transactional
    public void borrar(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new RuntimeException("No se puede borrar: Producto inexistente");
        }
        productoRepository.deleteById(id);
    }

    /**
     * Vincular proveedor a un producto
     * @param productoId ID de producto a vincular
     * @param proveedorId ID del proveedor a vincular
     */
    @Transactional
    public void vincularProveedor(Long productoId, Long proveedorId) {
        // Buscamos el producto
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Buscamos el proveedor
        Proveedor proveedor = proveedorRepository.findById(proveedorId)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        // Evitar duplicados
        if (!producto.getProveedores().contains(proveedor)) {
            producto.getProveedores().add(proveedor);
            productoRepository.save(producto);
        }
    }

    /**
     * Desvincular el producto de un proveedor
     * @param productoId ID del producto a desvincular
     * @param proveedorId ID del producto a desvincular
     */
    @Transactional
    public void desvincularProveedor(Long productoId, Long proveedorId) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Eliminar ID de la lista
        producto.getProveedores().removeIf(p -> p.getId().equals(proveedorId));
        productoRepository.save(producto);
    }
}
