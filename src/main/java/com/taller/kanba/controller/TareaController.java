package com.taller.kanba.controller;

import com.taller.kanba.dto.TareaCrearDTO;
import com.taller.kanba.dto.TareaEstadoDTO;
import com.taller.kanba.model.Tarea;
import com.taller.kanba.service.TareaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
@RequiredArgsConstructor
public class TareaController {

    private final TareaService tareaService;

    @GetMapping
    public List<Tarea> obtenerTodas() {
        return tareaService.obtenerTodas();
    }

    @PostMapping
    public Tarea crear(@Valid @RequestBody TareaCrearDTO dto) {
        return tareaService.crear(dto);
    }

    @PutMapping("/{id}/estado")
    public Tarea actualizarEstado(@PathVariable Long id, @Valid @RequestBody TareaEstadoDTO dto) {
        return tareaService.actualizarEstado(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        tareaService.eliminar(id);
    }
}