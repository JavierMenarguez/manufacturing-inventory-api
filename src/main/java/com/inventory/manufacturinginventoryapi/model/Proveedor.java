package com.inventory.manufacturinginventoryapi.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "proveedores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(length = 20)
    private String telefono;

    @Column(length = 150)
    private String email;

    private String direccion;

    @Column(nullable = false)
    private Boolean activo = true;
}
