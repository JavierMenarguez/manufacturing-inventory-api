package com.inventory.manufacturinginventoryapi.controller;

import com.inventory.manufacturinginventoryapi.model.MovimientoInventario;
import com.inventory.manufacturinginventoryapi.service.MovimientoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class MovimientoController {

    private final MovimientoService movimientoService;

    @GetMapping
    public List<MovimientoInventario> listar() {
        return movimientoService.listarTodo();
    }

    @PostMapping
    public ResponseEntity<?> registrarMovimiento(@RequestBody MovimientoInventario movimiento) {
        try {
            return ResponseEntity.ok(movimientoService.registrar(movimiento));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
