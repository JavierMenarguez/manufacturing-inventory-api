package com.inventory.manufacturinginventoryapi.repository;

import com.inventory.manufacturinginventoryapi.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
