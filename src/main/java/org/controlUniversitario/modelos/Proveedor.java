package org.controlUniversitario.modelos;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name="proveedores")
public class Proveedor {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String nombre;


}
