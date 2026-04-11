package com.cesde.gimnasio.model.entity;

import com.cesde.gimnasio.model.enums.TipoPlan;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "planes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Plan extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private TipoPlan nombre;

    private double precio;

    private String beneficios;

    @OneToMany(mappedBy = "plan")
    private List<Suscripcion> suscripciones = new ArrayList<>();
}
