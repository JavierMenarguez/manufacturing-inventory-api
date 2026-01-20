package com.inventory.manufacturinginventoryapi.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String sku;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    @Column(name = "precio_venta")
    private BigDecimal precioVenta;

    private Integer existencias;

    @Column(name = "punto_reorden")
    private Integer puntoReorden;

    @Column(name = "tipo_producto")
    private String tipoProducto; // MATERIA_PRIMA o FABRICADO

    @Column(nullable = false)
    private Boolean activo = true;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;


}
