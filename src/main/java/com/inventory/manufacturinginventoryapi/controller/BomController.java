package com.inventory.manufacturinginventoryapi.controller;

import com.inventory.manufacturinginventoryapi.model.BomEstructura;
import com.inventory.manufacturinginventoryapi.service.BomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bom")
@AllArgsConstructor
public class BomController {

    private final BomService bomService;

    @GetMapping
    public List<BomEstructura> listar() {
        return bomService.listarTodo();
    }

    @PostMapping
    public BomEstructura crear(@RequestBody BomEstructura bom) {
        return bomService.guardar(bom);
    }
}
