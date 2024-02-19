package com.edu.Back.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idProveedor;

    @Column(nullable = true , length = 50)
    private String nombre;

    @Column(nullable = true , length = 100)
    private String direccion;

    @Column(nullable = true , length = 100)
    private String telefono;

    @Column(nullable = true , length = 200 ,  unique = false)
    @Email(message = "El correo debe ser valido")
    private String email;
}
