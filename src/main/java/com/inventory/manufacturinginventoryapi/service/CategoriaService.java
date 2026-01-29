package com.inventory.manufacturinginventoryapi.service;

import com.inventory.manufacturinginventoryapi.model.Categoria;
import com.inventory.manufacturinginventoryapi.repository.CategoriaRepository;
import jakarta.transaction.Transactional;
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
     * Añade una categoria a BD
     * @param categoria Categoria a guardar
     * @return Devuelve la categoria guardada
     */
    @Transactional
    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    /**
     * Actualiza una categoria de la BD
     * @param id ID de la categoria a modificar
     * @param detalles Datos a sobrescribir
     * @return Devuelve la cateoria que ha sido modificada
     */
    @Transactional
    public Categoria modificar(Long id, Categoria detalles) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        categoria.setNombre(detalles.getNombre());
        return categoriaRepository.save(categoria);
    }

    /**
     * Elimina la categoria filtrada por ID
     * @param id ID de la categoria a eliminar
     */
    @Transactional
    public void borrar(Long id) {
        // Validación Pro: ¿Tiene productos asociados?
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
        } else {
            throw new RuntimeException("No existe la categoría");
        }
    }

}