package org.controlUniversitario.dtos.proveedor;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProveedorModificar implements Serializable {
    private Integer id;
    private String nombre;


}
