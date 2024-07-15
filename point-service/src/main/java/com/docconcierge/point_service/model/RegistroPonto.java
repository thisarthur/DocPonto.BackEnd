package com.docconcierge.point_service.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class RegistroPonto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long usuarioId;
    private LocalDate data;
    private LocalTime horario;

    @Enumerated(EnumType.STRING)
    private TipoPonto tipo;

    // Construtores, getters e setters
    public RegistroPonto() {
    }

    public RegistroPonto(Long usuarioId, LocalDate data, LocalTime horario, TipoPonto tipo) {
        this.usuarioId = usuarioId;
        this.data = data;
        this.horario = horario;
        this.tipo = tipo;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public TipoPonto getTipo() {
        return tipo;
    }

    public void setTipo(TipoPonto tipo) {
        this.tipo = tipo;
    }
}
