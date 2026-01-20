package com.inventory.manufacturinginventoryapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoProveedorID implements Serializable {
    private Long productoId;
    private Long proveedorId;
}
