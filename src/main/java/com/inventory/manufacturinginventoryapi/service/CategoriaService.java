package com.inventory.manufacturinginventoryapi.service;

import com.inventory.manufacturinginventoryapi.model.Categoria;
import com.inventory.manufacturinginventoryapi.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    /**
     * Obtener todas la categorias
     * @return Devuelve la lista de las categorias de BD
     */
    public List<Categoria> listarTodo() {
        return categoriaRepository.findAll();
    }

    /**
     * Buscar categoria por ID
     * @param id ID de la categoria a buscar
     * @return Devuelve la categoria encontrada
     */
    public Optional<Categoria> buscarPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    /**
     * Añade o actualiza una categoria a BD
     * @param categoria Categoria a guardar
     * @return Devuelve la categoria guardada
     */
    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    /**
     * Elimina la categoria filtrada por ID
     * @param id ID de la categoria a eliminar
     */
    public void eliminar(Long id) {
        categoriaRepository.deleteById(id);
    }
}