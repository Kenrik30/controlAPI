package org.controlUniversitario.dtos.herramienta;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class HerramientaModificar implements Serializable {

    private Integer id;
    private String nombre;
    private String descripcion;
    private String marca;
    private  String condicion;
    private Integer categoriaId;
}
