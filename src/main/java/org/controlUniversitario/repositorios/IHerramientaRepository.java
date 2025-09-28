package org.controlUniversitario.repositorios;

import org.controlUniversitario.modelos.Herramienta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHerramientaRepository extends JpaRepository<Herramienta, Integer> {
    // No necesitas declarar findById, ya viene incluido
}
