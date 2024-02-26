package com.edu.Back.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Modelo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idModelo;

    @Column
    private String nombre;

    @Column
    private String apellido;
}
