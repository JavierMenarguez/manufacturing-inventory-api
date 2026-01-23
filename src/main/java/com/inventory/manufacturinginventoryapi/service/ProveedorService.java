package com.inventory.manufacturinginventoryapi.service;

import com.inventory.manufacturinginventoryapi.model.Proveedor;
import com.inventory.manufacturinginventoryapi.repository.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    /**
     * Obtener todos los proveedores
     * @return Devuelve la lista de proveedores
     */
    public List<Proveedor> listarTodos() {
        return proveedorRepository.findAll();
    }

    /**
     * Obtener un producto por su ID
     * @param id ID del producto a buscar
     * @return Devuelve el proveedor encontrado
     */
    public Optional<Proveedor> buscarPorId(Long id) {
        return proveedorRepository.findById(id);
    }

    /**
     * Guardar un proveedor
     * @param proveedor Proveedor a guardar
     * @return Devuelve el proveedor que ha sido guardado
     */
    public Proveedor guardar(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    /**
     * Eliminar un producto por su ID
     * @param id ID del producto a eliminar
     */
    public void eliminar(Long id) {
        proveedorRepository.deleteById(id);
    }
}
