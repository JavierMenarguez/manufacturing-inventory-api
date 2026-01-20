package com.inventory.manufacturinginventoryapi.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "categorias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(unique = true, nullable = false, length = 100)
    private String nombre;

}
