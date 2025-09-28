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
import org.springframework.data.domain.PageImpl;
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

        Page<Herramienta> page = herramientaRepository.findAll(pageable);

        List<HerramientaSalida> herramientaDTO = page.stream()
                .map(herramienta -> modelMapper.map(herramienta, HerramientaSalida.class))
                .collect(Collectors.toList());

        return new PageImpl<>(herramientaDTO, page.getPageable(), page.getTotalElements());

    }

    @Override
    public HerramientaSalida obtenerPorId(Integer id) {
        return modelMapper.map(herramientaRepository.findById(id).get(), HerramientaSalida.class);
    }

    @Override
    public HerramientaSalida crear(HerramientaGuardar herramientaGuardar) {

        Herramienta herramienta = modelMapper.map(herramientaGuardar, Herramienta.class);
        herramienta.setId(null);
        herramienta.setEstado(Herramienta.Status.BUENESTADO);

        return modelMapper.map(herramientaRepository.save(herramienta), HerramientaSalida.class);
    }

    @Override
    public HerramientaSalida editar(HerramientaModificar herramientaModificar) {
        Herramienta herramienta = herramientaRepository.save(modelMapper.map(herramientaModificar, Herramienta.class));
        return modelMapper.map(herramienta, HerramientaSalida.class);
    }

    @Override
    public HerramientaSalida cambiarEstado (HerramientaCambiarEstado herramientaCambiarEstado) {
        Herramienta herramienta = herramientaRepository.findById(herramientaCambiarEstado.getId()).get();
        herramienta.setEstado(Herramienta.Status.valueOf(herramientaCambiarEstado.getEstado()));

        return modelMapper.map(herramientaRepository.save(herramienta), HerramientaSalida.class);
    }

    @Override
    public void eliminarPorId(Integer id) { herramientaRepository.deleteById(id);
    }
}
