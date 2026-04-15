package com.cesde.gimnasio.service;

import com.cesde.gimnasio.model.entity.Suscripcion;
import com.cesde.gimnasio.model.enums.TipoPlan;
import com.cesde.gimnasio.repository.SuscripcionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class SuscripcionService {

    private final SuscripcionRepository suscripcionRepository;

    public Suscripcion crearSuscripcion(Suscripcion suscripcion) {

        //VALIDACIONES
        if (suscripcion.getFechaInicio() == null) {
            throw new IllegalArgumentException("La fechaInicio es obligatoria");
        }

        if (suscripcion.getPlan() == null || suscripcion.getPlan().getNombre() == null) {
            throw new IllegalArgumentException("El plan es obligatorio");
        }

        LocalDate fechaInicio = suscripcion.getFechaInicio();

        // Logica para calcular la fechaFin según el tipo de plan
        if (suscripcion.getPlan().getNombre() == TipoPlan.MENSUAL) {
            suscripcion.setFechaFin(fechaInicio.plusDays(30));
        } else if (suscripcion.getPlan().getNombre() == TipoPlan.ANUAL) {
            suscripcion.setFechaFin(fechaInicio.plusDays(365));
        }

        return suscripcionRepository.save(suscripcion);
    }
}