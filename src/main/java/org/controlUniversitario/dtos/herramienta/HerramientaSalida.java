package org.controlUniversitario.dtos.herramienta;

import lombok.Getter;
import lombok.Setter;
import org.controlUniversitario.dtos.categoria.CategoriaSalida;

import java.io.Serializable;

@Getter
@Setter
public class HerramientaSalida implements Serializable {

    private Integer id;
    private String nombre;
    private String descripcion;
    private String marca;
    private  String estado;
    private CategoriaSalida salida;


}
