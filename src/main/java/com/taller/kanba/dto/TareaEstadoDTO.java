package com.taller.kanba.dto;

import com.taller.kanba.model.EstadoTarea;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TareaEstadoDTO {

    @NotNull(message = "El estado es obligatorio")
    private EstadoTarea estado;
}