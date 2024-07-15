package com.docconcierge.dep_filial_service.DTO;

public class DepartamentoDTO {

    private Long id;
    private String nome;
    private FilialDTO filial;


    public DepartamentoDTO() {}
    public DepartamentoDTO(Long id, String nome, FilialDTO filial) {
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

    public FilialDTO getFilial() {
        return filial;
    }

    public void setFilial(FilialDTO filial) {
        this.filial = filial;
    }
}
