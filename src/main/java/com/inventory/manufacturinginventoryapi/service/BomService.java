package com.inventory.manufacturinginventoryapi.service;

import com.inventory.manufacturinginventoryapi.model.BomEstructura;
import com.inventory.manufacturinginventoryapi.model.BomId;
import com.inventory.manufacturinginventoryapi.repository.BomEstructuraRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BomService {

    private final BomEstructuraRepository bomRepository;

    /**
     * Lista toda las estructuras registradas
     * @return Devuelve una lista de las estructuras/recetas
     */
    public List<BomEstructura> listarTodo() {
        return bomRepository.findAll();
    }

    /**
     * Busca todos los materiales/productosHijos que tiene uno de los productos padre
     * @param productoPadreId ID del producto padre a buscar
     * @return Devuelve una lista con los hijos del elemento padre buscado
     */
    public List<BomEstructura> buscarPorProductoIdPadre(Long productoPadreId) {
        return bomRepository.findByIdProductoFinalId(productoPadreId);
    }

    /**
     * Guarda una nueva estrutura
     * @param bom Producto a crear en BD
     * @return Devuelve el producto guardado
     */
    @Transactional
    public BomEstructura guardar(BomEstructura bom) {
        if (bom.getProductoFinal().getId().equals(bom.getComponente().getId())) {
            throw new RuntimeException("Un producto no puede ser ingrediente de sí mismo");
        }
        return bomRepository.save(bom);
    }

    @Transactional
    public BomEstructura actualizarComponente(Long productoFinalId, Long componenteId, BomEstructura detalles) {
        // Creamos la llave compuesta
        BomId id = new BomId(productoFinalId, componenteId);

        // Buscamos el registro existente
        return bomRepository.findById(id).map(ingrediente -> {
            // Actualizamos los campos permitidos
            ingrediente.setCantidadNecesaria(detalles.getCantidadNecesaria());
            ingrediente.setUnidadMedida(detalles.getUnidadMedida());


            return bomRepository.save(ingrediente);
        }).orElseThrow(() -> new RuntimeException("No se encontró el ingrediente en la receta para actualizar"));
    }

    /**
     * Borra un componente de la receta del producto
     * @param productoFinalId ID del producto final a obtener su receta
     * @param componenteId ID del elemento a eliminar de la receta
     */
    @Transactional
    public void borrarComponente(Long productoFinalId, Long componenteId) {
        BomId idCompuesto = new BomId(productoFinalId, componenteId);

        if (!bomRepository.existsById(idCompuesto)) {
            throw new RuntimeException("No existe ese ingrediente en la receta");
        }
        bomRepository.deleteById(idCompuesto);
    }

    /**
     * Borra todos los componentes de una receta
     * @param productoFinalId ID del elemento padre a borrar todos sus componentes
     */
    @Transactional
    public void borrarEstructuraCompleta(Long productoFinalId) {
        bomRepository.deleteByProductoFinalId(productoFinalId);
    }
}
