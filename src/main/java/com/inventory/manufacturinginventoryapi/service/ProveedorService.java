package com.inventory.manufacturinginventoryapi.service;

import com.inventory.manufacturinginventoryapi.model.Proveedor;
import com.inventory.manufacturinginventoryapi.repository.ProveedorRepository;
import jakarta.transaction.Transactional;
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
    @Transactional
    public Proveedor guardar(Proveedor proveedor) {
        proveedor.setNombre(proveedor.getNombre().trim());
        return proveedorRepository.save(proveedor);
    }

    @Transactional
    public Proveedor modificar(Long id, Proveedor detalles) {
        return proveedorRepository.findById(id).map(prov -> {
            // Usamos la técnica de "actualizarDatos" que comentamos antes
            prov.setNombre(detalles.getNombre());
            prov.setTelefono(detalles.getTelefono());
            prov.setEmail(detalles.getEmail());
            prov.setDireccion(detalles.getDireccion());
            prov.setActivo(detalles.getActivo());
            return proveedorRepository.save(prov);
        }).orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
    }

    /**
     * Eliminar un producto por su ID
     * @param id ID del producto a eliminar
     */
    @Transactional
    public void borrar(Long id) {
        if (!proveedorRepository.existsById(id)) {
            throw new RuntimeException("El proveedor no existe");
        }
        proveedorRepository.deleteById(id);
    }
}
