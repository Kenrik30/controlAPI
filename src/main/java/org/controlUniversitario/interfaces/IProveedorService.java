package org.controlUniversitario.interfaces;

import org.controlUniversitario.dtos.proveedor.ProveedorGuardar;
import org.controlUniversitario.dtos.proveedor.ProveedorModificar;
import org.controlUniversitario.dtos.proveedor.ProveedorSalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
//declarion de metodos
public interface IProveedorService {

    List<ProveedorSalida> obtenerTodos();

    Page<ProveedorSalida> obtenerTodosPaginados(Pageable pageable);

    ProveedorSalida obtenerPorId(Integer id);

    ProveedorSalida crear(ProveedorGuardar proveedorGuardar);

    ProveedorSalida editar(ProveedorModificar proveedorModificar);

    void eliminarPorId(Integer id);

}
