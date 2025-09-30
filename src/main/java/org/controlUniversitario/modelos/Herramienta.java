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

    @ManyToOne
    @JoinColumn(name = "categoria_id" )
private Categoria categoria;

    public Status getEstado() {
        return estado;
    }

    public static enum Status {
        BUENESTADO, INSERVIBLE, MANTENIMIENTO
    }
}
