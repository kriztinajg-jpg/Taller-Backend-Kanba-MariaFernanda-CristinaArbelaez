package com.taller.kanba.service;

import com.taller.kanba.dto.TareaCrearDTO;
import com.taller.kanba.dto.TareaEstadoDTO;
import com.taller.kanba.model.EstadoTarea;
import com.taller.kanba.model.Tarea;
import com.taller.kanba.repository.TareaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TareaService {

    private final TareaRepository tareaRepository;

    public List<Tarea> obtenerTodas() {
        return tareaRepository.findAll();
    }

    public Tarea crear(TareaCrearDTO dto) {
        Tarea tarea = new Tarea();
        tarea.setTitulo(dto.getTitulo());
        tarea.setDescripcion(dto.getDescripcion());
        tarea.setEstado(EstadoTarea.POR_HACER);
        tarea.setFechaCreacion(LocalDateTime.now());
        return tareaRepository.save(tarea);
    }

    public Tarea actualizarEstado(Long id, TareaEstadoDTO dto) {
        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarea no encontrada"));

        tarea.setEstado(dto.getEstado());
        return tareaRepository.save(tarea);
    }

    public void eliminar(Long id) {
        if (!tareaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarea no encontrada");
        }
        tareaRepository.deleteById(id);
    }
}