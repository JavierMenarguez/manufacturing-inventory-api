package com.inventory.manufacturinginventoryapi.service;

import com.inventory.manufacturinginventoryapi.model.BomEstructura;
import com.inventory.manufacturinginventoryapi.repository.BomEstructuraRepository;
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
     * Buscar los materiales/productosHijos que tiene uno de los productos padre
     * @param productoPadreId ID del producto padre a buscar
     * @return Devuelve una lista con los hijos del elemento padre buscado
     */
    public List<BomEstructura> buscarPorProductoId(Long productoPadreId) {
        return bomRepository.findByIdProductoFinalId(productoPadreId);
    }

    /**
     * Guarda una nueva estrutura
     * @param bom Producto a crear en BD
     * @return Devuelve el producto guardado
     */
    public BomEstructura guardar(BomEstructura bom) {
        return bomRepository.save(bom);
    }
}
