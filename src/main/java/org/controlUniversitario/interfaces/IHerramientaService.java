package org.controlUniversitario.interfaces;

import org.controlUniversitario.dtos.herramienta.HerramientaCambiarEstado;
import org.controlUniversitario.dtos.herramienta.HerramientaGuardar;
import org.controlUniversitario.dtos.herramienta.HerramientaModificar;
import org.controlUniversitario.dtos.herramienta.HerramientaSalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IHerramientaService {

    List<HerramientaSalida> obtenerTodos();

    Page<HerramientaSalida> obtenerTodosPaginados(Pageable pageable);

    HerramientaSalida obtenerPorId(Integer id);

    HerramientaSalida crear(HerramientaGuardar herramientaGuardar);

    HerramientaSalida editar(HerramientaModificar herramientaModificar);

    HerramientaSalida cambiarCondicion(HerramientaCambiarEstado herramientaCambiarEstado);

    void eliminarPorId(Integer id);
}
