package org.controlUniversitario.dtos.herramienta;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class HerramientaCambiarEstado implements Serializable {
private Integer id;
private String condicion ;

}
