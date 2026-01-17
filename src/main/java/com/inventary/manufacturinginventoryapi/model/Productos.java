package com.inventary.manufacturinginventoryapi.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "productos") // Nombre en BD
@Data //getters, setters y constructores automáticamente
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Este mapea con tu BIGSERIAL

    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    private BigDecimal precio;

    private Integer existencias;
}
