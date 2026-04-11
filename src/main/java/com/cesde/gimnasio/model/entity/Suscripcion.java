package com.cesde.gimnasio.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "suscripciones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Suscripcion extends BaseEntity{

    private LocalDate fechaInicio;

    private  LocalDate fechaFin;

    private boolean activa;

    @ManyToOne
    @JoinColumn(name = "socio_id", nullable = false)
    private Socio socio;

    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    private Plan plan;

}
