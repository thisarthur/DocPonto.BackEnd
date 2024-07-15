package com.docconcierge.point_service.DTO;

import com.docconcierge.point_service.model.TipoPonto;
import java.time.LocalDate;
import java.time.LocalTime;

public class RegistroPontoDTO {
    private Long id;
    private Long usuarioId;
    private LocalDate data;
    private LocalTime horario;
    private TipoPonto tipo;

    // Construtores, getters e setters
    public RegistroPontoDTO() {
    }

    public RegistroPontoDTO(Long id, Long usuarioId, LocalDate data, LocalTime horario, TipoPonto tipo) {
        this.id = id;
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
