package org.controlUniversitario.implementaciones;

import org.controlUniversitario.dtos.herramienta.HerramientaCambiarEstado;
import org.controlUniversitario.dtos.herramienta.HerramientaGuardar;
import org.controlUniversitario.dtos.herramienta.HerramientaModificar;
import org.controlUniversitario.dtos.herramienta.HerramientaSalida;
import org.controlUniversitario.interfaces.IHerramientaService;
import org.controlUniversitario.modelos.Herramienta;
import org.controlUniversitario.repositorios.IHerramientaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HerramientaService implements IHerramientaService {

    @Autowired
    private IHerramientaRepository herramientaRepository;
@Autowired
    private ModelMapper modelMapper;

    @Override
    public List<HerramientaSalida> obtenerTodos() {
        List<Herramienta> herramientas = herramientaRepository.findAll();

        return herramientas.stream()
                .map(herramienta -> modelMapper.map(herramienta, HerramientaSalida.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<HerramientaSalida> obtenerTodosPaginados(Pageable pageable) {
        return null;
    }

    @Override
    public HerramientaSalida obtenerPorId(Integer id) {
        return null;
    }

    @Override
    public HerramientaSalida crear(HerramientaGuardar herramientaGuardar) {
        return null;
    }

    @Override
    public HerramientaSalida editar(HerramientaModificar herramientaModificar) {
        return null;
    }

    @Override
    public HerramientaSalida cambiarCondicion(HerramientaCambiarEstado herramientaCambiarEstado) {
        return null;
    }

    @Override
    public void eliminarPorId(Integer id) {

    }
}
