package com.inventory.manufacturinginventoryapi.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimientos_inventario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoInventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    // Tipo de movimiento: 'ENTRADA', 'SALIDA', 'AJUSTE'
    @Column(name = "tipo_movimiento", nullable = false, length = 20)
    private String tipoMovimiento;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal cantidad;

    @Column(name = "fecha", nullable = false, updatable = false)
    private LocalDateTime fechaMovimiento;

    @Column(length = 100)
    private String referencia;

    @Column(columnDefinition = "TEXT")
    private String notas;

    // Guardar fecha y hora de creacion del movimiento
    @PrePersist
    protected void onCreate() {
        this.fechaMovimiento = java.time.LocalDateTime.now();
    }
}