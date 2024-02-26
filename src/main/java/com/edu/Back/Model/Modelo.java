package com.edu.Back.Model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Modelo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idModelo;

    @Column
    private String nombre;

    @Column
    private String apellido;
}
