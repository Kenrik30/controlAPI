package org.controlUniversitario.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categorias")

public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String nombre;

    //relacion con otra entidad del proyecto
    @ManyToOne
    @JoinColumn(name = "herramienta_id")
private Herramienta herramienta;

}