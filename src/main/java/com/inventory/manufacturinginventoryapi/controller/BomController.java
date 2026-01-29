package com.inventory.manufacturinginventoryapi.controller;

import com.inventory.manufacturinginventoryapi.model.BomEstructura;
import com.inventory.manufacturinginventoryapi.service.BomService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bom")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class BomController {

    private final BomService bomService;

    @GetMapping
    public List<BomEstructura> listar() {
        return bomService.listarTodo();
    }

    // /api/bom/producto/5
    @GetMapping("/producto/{productoId}")
    public List<BomEstructura> obtenerReceta(@PathVariable Long productoId) {
        return bomService.buscarPorProductoIdPadre(productoId);
    }

    @PostMapping
    public ResponseEntity<BomEstructura> anadirIngrediente(@RequestBody BomEstructura bom) {
        return new ResponseEntity<>(bomService.guardar(bom), HttpStatus.CREATED);
    }

    @PutMapping("/producto/{productoFinalId}/componente/{componenteId}")
    public ResponseEntity<BomEstructura> editarComponente(@PathVariable Long productoFinalId, @PathVariable Long componenteId, @RequestBody BomEstructura detalles) {
        try {
            BomEstructura actualizado = bomService.actualizarComponente(productoFinalId, componenteId, detalles);
            // 200 OK
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            // 404
            return ResponseEntity.notFound().build();
        }
    }

    // /api/bom/producto/5/componente/7
    @DeleteMapping("/producto/{productoId}/componente/{componenteId}")
    public ResponseEntity<Void> borrarIngrediente(@PathVariable Long productoId, @PathVariable Long componenteId) {
        bomService.borrarComponente(productoId, componenteId);
        return ResponseEntity.noContent().build();
    }

    // /api/bom/producto/5/limpiar
    @DeleteMapping("/producto/{productoId}/limpiar")
    public ResponseEntity<Void> borrarReceta(@PathVariable Long productoId) {
        bomService.borrarEstructuraCompleta(productoId);
        return ResponseEntity.noContent().build();
    }
}
