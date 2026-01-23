package com.inventory.manufacturinginventoryapi.service;

import com.inventory.manufacturinginventoryapi.model.Producto;
import com.inventory.manufacturinginventoryapi.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    /**
     * Obtener la lista completa de productos
     * @return Devuelve la lista completa
     */
    public List<Producto> listarTodo() {
        return productoRepository.findAll();
    }

    /**
     * Guardar nuevo procucto
     * @param producto Producto a guardar
     * @return Devuelve el producto guardado
     */
    public Producto guardar(Producto producto) {
        // Aquí podrías añadir lógica, ej: validar que el SKU no esté repetido
        return productoRepository.save(producto);
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
     * Eliminar producto
     * @param id ID del producto a eliminar
     */
    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
}
