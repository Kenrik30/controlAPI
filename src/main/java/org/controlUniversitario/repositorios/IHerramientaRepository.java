package org.controlUniversitario.repositorios;

import org.controlUniversitario.modelos.Herramienta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IHerramientaRepository extends JpaRepository<Herramienta, Integer> {

    List<Herramienta> findByHerramientaId(Integer id);

}
