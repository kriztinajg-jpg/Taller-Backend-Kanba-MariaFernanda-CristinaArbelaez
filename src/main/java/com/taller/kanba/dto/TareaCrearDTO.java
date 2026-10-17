package com.taller.kanba.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TareaCrearDTO {

    @NotBlank(message = "El título no puede estar vacío")
    private String titulo;

    private String descripcion;
}