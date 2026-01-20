package com.inventory.manufacturinginventoryapi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "producto_proveedor")
@Data
public class ProductoProveedor {

    @EmbeddedId
    private ProductoProveedorID id;

    @ManyToOne
    @MapsId("productoId")
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne
    @MapsId("proveedorId")
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;

}
