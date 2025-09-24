package org.controlUniversitario.interfaces;

import org.controlUniversitario.dtos.categoria.CategoriaGuardar;
import org.controlUniversitario.dtos.categoria.CategoriaModificar;
import org.controlUniversitario.dtos.categoria.CategoriaSalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoriaService {

    List<CategoriaSalida> obtenerTodos();

    Page<CategoriaSalida> obtenerTodosPaginados(Pageable pageable);

    CategoriaSalida obtenerPorId(Integer id);

    CategoriaSalida crear(CategoriaGuardar categoriaGuardar);

    CategoriaSalida editar(CategoriaModificar categoriaModificar);

    void eliminarPorId(Integer id);

}
