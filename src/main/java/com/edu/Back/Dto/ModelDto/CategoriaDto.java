package com.edu.Back.Dto.ModelDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class CategoriaDto {

    private Integer idCategoria;


    @Schema (description = "NombreCategoria")
    @NotNull
    @Size(min = 3 , message = "{Valores minimos de ingreso 3}")
    private String nombre;

}
