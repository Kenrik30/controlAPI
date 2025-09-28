package org.controlUniversitario.modelos;

import jakarta.persistence.*;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "herramientas")

public class Herramienta {
@Id
@GeneratedValue( strategy = GenerationType.IDENTITY)

    //definicion de atributos de la entidad
    private Integer id;

    private String nombre;

    private String descripcion;

    private String marca;

//para guardar en la base de datos el texto del estatus de las herramientas

    @Enumerated(EnumType.STRING)
    private Status estado;

    @OneToMany(mappedBy = "herramienta" )
private List<Categoria> categorias;

    public Status getEstado() {
        return estado;
    }

    public void setEstado(Status status) {

    }

    public void setId(Object o) {

    }

    public static enum Status {
        BUENESTADO, INSERVIBLE, MANTENIMIENTO
    }



}
