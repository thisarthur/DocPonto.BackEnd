package com.docconcierge.dep_filial_service.model;

import jakarta.persistence.*;

@Entity
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "filial_id")
    private Filial filial;

    public Departamento(){

    }
    public Departamento(Long id, String nome, Filial filial) {
        this.id = id;
        this.nome = nome;
        this.filial = filial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }
}
