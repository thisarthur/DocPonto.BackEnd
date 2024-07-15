package com.docconcierge.dep_filial_service.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Filial {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "filial")
    private List<Departamento> departamentos;

    public Filial(){

    }
    public Filial(Long id, String nome, List<Departamento> departamentos) {
        this.id = id;
        this.nome = nome;
        this.departamentos = departamentos;
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

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
}
