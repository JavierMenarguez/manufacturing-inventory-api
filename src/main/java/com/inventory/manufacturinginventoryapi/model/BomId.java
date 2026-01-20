package com.inventory.manufacturinginventoryapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BomId implements Serializable {
    private Long productoFinalId;
    private Long componenteId;
}
