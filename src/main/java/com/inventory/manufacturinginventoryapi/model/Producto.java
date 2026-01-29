package com.inventory.manufacturinginventoryapi.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 100)
    private String sku;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "precio_venta", precision = 10, scale = 2)
    private BigDecimal precioVenta;

    @Column(precision = 10, scale = 2)
    private BigDecimal existencias;

    @Column(name = "unidad_medida")
    private String unidadMedida;

    @Column(name = "punto_reorden")
    private Integer puntoReorden;

    @Column(name = "tipo_producto",length = 100)
    private String tipoProducto; // MATERIA_PRIMA o PRODUCTO FINAL

    @Column(nullable = false)
    private Boolean activo = true;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToMany
    @JoinTable(
            name = "producto_proveedor",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "proveedor_id")
    )
    private List<Proveedor> proveedores = new ArrayList<>();

}
