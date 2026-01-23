package com.inventory.manufacturinginventoryapi.repository;

import com.inventory.manufacturinginventoryapi.model.BomEstructura;
import com.inventory.manufacturinginventoryapi.model.BomId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BomEstructuraRepository extends JpaRepository<BomEstructura, BomId>{

    // Consulta a BD personalizada
    List<BomEstructura> findByIdProductoFinalId(Long productoFinalId);
}
