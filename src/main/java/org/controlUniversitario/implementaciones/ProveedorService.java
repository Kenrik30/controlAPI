package org.controlUniversitario.implementaciones;

import org.controlUniversitario.dtos.proveedor.ProveedorGuardar;
import org.controlUniversitario.dtos.proveedor.ProveedorModificar;
import org.controlUniversitario.dtos.proveedor.ProveedorSalida;

import org.controlUniversitario.interfaces.IProveedorService;
import org.controlUniversitario.modelos.Proveedor;
import org.controlUniversitario.repositorios.IProveedorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProveedorService implements IProveedorService {

    @Autowired
    private IProveedorRepository proveedorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProveedorSalida> obtenerTodos() {
        List<Proveedor> proveedores = proveedorRepository.findAll();
        return proveedores.stream()
                .map(proveedor -> modelMapper.map(proveedor, ProveedorSalida.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<ProveedorSalida> obtenerTodosPaginados(Pageable pageable) {
        Page<Proveedor> page = proveedorRepository.findAll(pageable);

        List<ProveedorSalida> proveedorDTO = page.stream()
                .map(proveedor -> modelMapper.map(proveedor, ProveedorSalida.class))
                .collect(Collectors.toList());

        return new PageImpl<>(proveedorDTO, page.getPageable(), page.getTotalElements());
    }

    @Override
    public ProveedorSalida obtenerPorId(Integer id) {
        return modelMapper.map(proveedorRepository.findById(id).get(), ProveedorSalida.class);
    }

    @Override
    public ProveedorSalida crear(ProveedorGuardar proveedorGuardar) {
        Proveedor proveedor = proveedorRepository.save(modelMapper.map(proveedorGuardar, Proveedor.class));
        return modelMapper.map(proveedor, ProveedorSalida.class);
    }

    @Override
    public ProveedorSalida editar(ProveedorModificar proveedorModificar) {
        Proveedor proveedor = proveedorRepository.save(modelMapper.map(proveedorModificar, Proveedor.class));
        return modelMapper.map(proveedor, ProveedorSalida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {proveedorRepository.deleteById(id);}
}

