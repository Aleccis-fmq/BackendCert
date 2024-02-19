package com.edu.Back.Model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    @Column(nullable = true , length = 30)
    private String nombre;

    @Column(nullable = true , length = 60)
    private String descripcion;
    @Column(nullable = true)
    private Float precio;

    @Column(nullable = true )
    private Integer cantidadStock;

    //adds fk
    @ManyToOne
    @JoinColumn(name = "id_proveedor" , nullable = false,
    foreignKey = @ForeignKey (name = "FkProductoProveedor"))
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "id_categoria" , nullable = false,
            foreignKey = @ForeignKey (name = "FkProductoCategoria"))
    private Categoria categoria;
}
