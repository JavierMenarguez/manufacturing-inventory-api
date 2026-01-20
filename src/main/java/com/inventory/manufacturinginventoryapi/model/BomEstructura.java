package com.inventory.manufacturinginventoryapi.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "bom_estructura")
@Data
public class BomEstructura {

    @EmbeddedId
    private BomId id;

    @ManyToOne
    @MapsId("productoFinalId")
    @JoinColumn(name = "producto_final_id")
    private Producto productoFinal;

    @ManyToOne
    @MapsId("componenteId")
    @JoinColumn(name = "componente_id")
    private Producto componente;

    @Column(name = "cantidad_necesaria", precision = 10, scale = 2)
    private BigDecimal cantidadNecesaria;

    @Column(name = "unidad_medida")
    private String unidadMedida;
}
