package org.controlUniversitario.modelos;

import jakarta.persistence.*;
import jdk.jshell.Snippet;
import lombok.Getter;
import lombok.Setter;
import org.controlUniversitario.Categoria;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Getter
@Setter
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
    private Status condicion;

    @OneToMany(mappedBy = "herramienta" )
private List<Categoria> categorias;

    private static enum Status{
        BUENESTADO, INSERVIBLE, MANTENIMIENTO
    }



}
